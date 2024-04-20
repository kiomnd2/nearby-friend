package com.example.nearbyfriend.infrastructure;

import com.example.nearbyfriend.domain.GeoLocation;
import com.example.nearbyfriend.domain.LocationStore;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@RequiredArgsConstructor
@Component
public class LocationStoreImpl implements LocationStore {
    private final LocationRepository locationRepository;
    private final KafkaTemplate<String, Object> kafkaTemplate;
    private final ObjectMapper objectMapper;

    @Transactional
    @Override
    public void store(GeoLocation location) throws IOException {
        locationRepository.save(location);
        kafkaTemplate.send("topic", objectMapper.writeValueAsString(location));
    }
}
