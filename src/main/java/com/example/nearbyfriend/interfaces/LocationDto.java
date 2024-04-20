package com.example.nearbyfriend.interfaces;

import com.example.nearbyfriend.domain.GeoLocation;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

public class LocationDto {

    @Getter
    @Setter
    @ToString
    public static class CreateLocationHistory {
        private Long userId;
        private Long latitude;
        private Long longitude;
        private String userMode;
        private String navigationMode;

        public GeoLocation toEntity() {
            return GeoLocation.builder()
                    .userId(userId)
                    .latitude(latitude)
                    .longitude(longitude)
                    .userMode(userMode)
                    .navigationMode(navigationMode)
                    .build();
        }
    }
}
