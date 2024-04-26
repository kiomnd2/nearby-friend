package com.example.nearbyfriend.domain.location;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor
public class Location {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userId;
    private Long latitude;
    private Long longitude;
    private String userMode;
    private LocalDateTime createAt;

    @Builder
    public Location(String userId, Long latitude, Long longitude, String userMode, String navigationMode) {
        this.userId = userId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.userMode = userMode;
        this.createAt = LocalDateTime.now();
    }

    public LocationCommand.KafkaProduceCommand toKafkaCommand() {
        return LocationCommand.KafkaProduceCommand.builder()
                .userId(userId)
                .latitude(latitude)
                .longitude(longitude)
                .userMode(userMode)
                .createAt(createAt)
                .build();
    }

    public LocationCommand.RedisStoreCommand toRedisStoreCommand() {
        return LocationCommand.RedisStoreCommand.builder()
                .latitude(latitude)
                .longitude(longitude)
                .userMode(userMode)
                .createAt(createAt)
                .build();
    }
}
