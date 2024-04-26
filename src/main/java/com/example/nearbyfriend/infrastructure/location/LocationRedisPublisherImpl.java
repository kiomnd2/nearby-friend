package com.example.nearbyfriend.infrastructure.location;

import com.example.nearbyfriend.domain.location.LocationCommand;
import com.example.nearbyfriend.domain.location.LocationRedisPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class LocationRedisPublisherImpl implements LocationRedisPublisher {
    private final RedisTemplate<String, Object> redisTemplate;

    @Override
    public void publish(String userId, LocationCommand.RedisStoreCommand redisStoreCommand) {
        redisTemplate.convertAndSend(userId, redisStoreCommand);
    }
}
