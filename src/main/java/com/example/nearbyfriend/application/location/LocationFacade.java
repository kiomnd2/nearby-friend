package com.example.nearbyfriend.application.location;

import com.example.nearbyfriend.domain.location.Location;
import com.example.nearbyfriend.domain.location.LocationHistoryStore;
import com.example.nearbyfriend.infrastructure.location.LocationKafkaMessageProducer;
import com.example.nearbyfriend.infrastructure.location.LocationRedisRepository;
import com.example.nearbyfriend.interfaces.location.LocationMessageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class LocationFacade {
    private final LocationHistoryStore locationHistoryStore;
    private final LocationKafkaMessageProducer locationKafkaMessageProducer;
    private final LocationRedisRepository locationRedisRepository;


    @Transactional
    public void alarmLocation(LocationMessageDto.AlarmLocation alarmLocation) {
        // 이력 저장
        Location location = alarmLocation.toEntity();
        locationHistoryStore.store(location);
        locationKafkaMessageProducer.produceKafka(location.toKafkaCommand());
        locationRedisRepository.addLocation(alarmLocation.getUserId(), location.toRedisStoreCommand());

        // member 의 친구 조회 후 알람
    }
}
