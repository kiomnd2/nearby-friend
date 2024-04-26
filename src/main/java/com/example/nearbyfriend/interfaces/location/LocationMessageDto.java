package com.example.nearbyfriend.interfaces.location;

import com.example.nearbyfriend.domain.location.Location;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class LocationMessageDto {

    @Getter
    @Setter
    @ToString
    public static class AlarmLocation {
        private String userId;
        private Long latitude; // 위도
        private Long longitude; // 경도
        private String userMode;

        public Location toEntity() {
            return Location.builder()
                    .userId(userId)
                    .latitude(latitude)
                    .longitude(longitude)
                    .userMode(userMode)
                    .build();
        }
    }
}
