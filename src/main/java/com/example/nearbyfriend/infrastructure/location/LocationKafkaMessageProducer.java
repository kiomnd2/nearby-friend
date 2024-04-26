package com.example.nearbyfriend.infrastructure.location;

import com.example.nearbyfriend.domain.location.Location;
import com.example.nearbyfriend.domain.location.LocationCommand;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class LocationKafkaMessageProducer {
    private final KafkaTemplate<String, Object> kafkaTemplate;
    private final ObjectMapper objectMapper;

    public void produceKafka(LocationCommand.KafkaProduceCommand location) {
        try {
            kafkaTemplate.send("topic", objectMapper.writeValueAsString(location));
        } catch (Exception e) {
            System.out.println("카프사 송신중 실패");
            e.printStackTrace();
        }
    }
}
