package com.example.nearbyfriend.domain;

import com.example.nearbyfriend.interfaces.LocationDto;

import java.io.IOException;

public interface LocationStore {
    void store(GeoLocation location) throws IOException;
}
