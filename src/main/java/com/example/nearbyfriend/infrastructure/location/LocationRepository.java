package com.example.nearbyfriend.infrastructure.location;

import com.example.nearbyfriend.domain.location.GeoLocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<GeoLocation, Long> {
}
