package com.example.nearbyfriend.domain.location;

import lombok.*;

import java.time.LocalDateTime;

public class LocationCommand {

    @AllArgsConstructor
    @Builder
    @NoArgsConstructor
    @ToString
    @Getter
    public static class KafkaProduceCommand {
        private String userId;
        private Long latitude;
        private Long longitude;
        private String userMode;
        private LocalDateTime createAt;
    }


    @AllArgsConstructor
    @Builder
    @NoArgsConstructor
    @ToString
    @Getter
    public static class RedisStoreCommand {
        private String userId;
        private Long latitude;
        private Long longitude;
        private String userMode;
        private LocalDateTime createAt;

    }
}
