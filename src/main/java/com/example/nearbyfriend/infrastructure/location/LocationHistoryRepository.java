package com.example.nearbyfriend.infrastructure.location;

import com.example.nearbyfriend.domain.location.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationHistoryRepository extends JpaRepository<Location, Long> {
}
