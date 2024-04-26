package com.example.nearbyfriend.infrastructure.location;

import com.example.nearbyfriend.domain.location.Location;
import com.example.nearbyfriend.domain.location.LocationCommand;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
@Repository
public class LocationRedisRepository {
    private final RedisTemplate<String, Object> redisTemplate;
    private final RedisMessageListenerContainer redisMessageListenerContainer;
    private final RedisMessageSubscriber redisMessageSubscriber;
    private HashOperations<String, Object, LocationCommand.RedisStoreCommand> locationHash;
    private static final String prefix = "loc:";

    @PostConstruct
    private void init() {
        locationHash = redisTemplate.opsForHash();
    }

    public void addLocation(String userId, LocationCommand.RedisStoreCommand location) {
        LocationCommand.RedisStoreCommand s = locationHash.get(prefix + userId, userId);
        if (s == null) {
            locationHash.put(prefix + userId, userId, location);
        }
        redisTemplate.expire(prefix + userId, 10, TimeUnit.MINUTES); // 10 분
    }

    public LocationCommand.RedisStoreCommand getLocation(String userId) {
        return locationHash.get(prefix + userId, userId);
    }

    // 멤버에 구독,,
    public void subscribeMember(String topic) {
        redisMessageListenerContainer.addMessageListener(redisMessageSubscriber, new ChannelTopic(topic));
    }
}
