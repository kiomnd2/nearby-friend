package com.example.nearbyfriend.domain.location;

import java.io.IOException;

public interface LocationStore {
    void store(GeoLocation location) throws IOException;
}
