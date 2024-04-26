package com.example.nearbyfriend.infrastructure.location;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class RedisMessageSubscriber implements MessageListener {
    private final ObjectMapper objectMapper;
    @Override
    public void onMessage(Message message, byte[] pattern) {

    }
}
