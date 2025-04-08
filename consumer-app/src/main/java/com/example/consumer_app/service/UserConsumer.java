package com.example.consumer_app.service;

import com.example.shared.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class UserConsumer {

    private final List<User> receivedUsers = Collections.synchronizedList(new ArrayList<>());

    @KafkaListener(topics = "user-topic", groupId = "user-group")
    public void listen(User user) {
        System.out.println("Received User: " + user.getName() + ", Age: " + user.getAge());
        receivedUsers.add(user);
    }

    public List<User> getReceivedUsers() {
        return receivedUsers;
    }
}
