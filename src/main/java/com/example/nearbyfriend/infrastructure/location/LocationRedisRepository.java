package com.example.nearbyfriend.infrastructure.location;

import com.example.nearbyfriend.domain.location.Location;
import com.example.nearbyfriend.domain.location.LocationCommand;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
@Repository
public class LocationRedisRepository {
    private final RedisTemplate<String, Object> redisTemplate;
    private HashOperations<String, Object, LocationCommand.RedisStoreCommand> locationHash;
    @PostConstruct
    private void init() {
        locationHash = redisTemplate.opsForHash();
    }

    public void addLocation(String userId, LocationCommand.RedisStoreCommand location) {
        String prefix = "loc:";
        LocationCommand.RedisStoreCommand s = locationHash.get(userId, prefix+userId);
        if (s == null) {
            locationHash.put(userId, prefix+userId, location);
        }
        redisTemplate.expire(userId, 10, TimeUnit.MINUTES); // 10 분
    }
}
