package com.example.nearbyfriend.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@NoArgsConstructor
@Entity
public class GeoLocation {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private Long latitude;
    private Long longitude;
    private String userMode;
    private String navigationMode;

    @CreatedDate
    private LocalDateTime createAt;

    @Builder
    public GeoLocation(Long userId, Long latitude, Long longitude, String userMode, String navigationMode) {
        this.userId = userId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.userMode = userMode;
        this.navigationMode = navigationMode;
    }
}
