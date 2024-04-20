package com.example.nearbyfriend.infrastructure;

import com.example.nearbyfriend.domain.GeoLocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<GeoLocation, Long> {
}
