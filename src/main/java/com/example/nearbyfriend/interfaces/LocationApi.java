package com.example.nearbyfriend.interfaces;

import com.example.nearbyfriend.domain.LocationStore;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class LocationApi {
    private final LocationStore locationStore;

    @PostMapping("/api/location")
    public void storeLocation(@RequestBody LocationDto.CreateLocationHistory history) throws Exception{
        locationStore.store(history.toEntity());
    }
}
