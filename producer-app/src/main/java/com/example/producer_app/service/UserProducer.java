package com.example.producer_app.service;

import com.example.shared.User;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserProducer {
    private final KafkaTemplate<String, User> kafkaTemplate;

    public UserProducer(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(User user) {
        kafkaTemplate.send("user-topic", user);
    }
}
