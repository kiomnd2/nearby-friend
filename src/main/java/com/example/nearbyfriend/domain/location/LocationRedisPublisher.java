package com.example.nearbyfriend.domain.location;

public interface LocationRedisPublisher {
    void publish(String userId, LocationCommand.RedisStoreCommand redisStoreCommand);
}
