package com.example.nearbyfriend.infrastructure.location;

import com.example.nearbyfriend.domain.location.Location;
import com.example.nearbyfriend.domain.location.LocationHistoryStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Component
public class LocationHistoryHistoryStoreImpl implements LocationHistoryStore {
    private final LocationHistoryRepository locationHistoryRepository;


    @Transactional
    @Override
    public void store(Location location) {
        locationHistoryRepository.save(location); // 이력 저장
    }
}
