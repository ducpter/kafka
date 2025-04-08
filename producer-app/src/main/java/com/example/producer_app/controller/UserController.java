package com.example.producer_app.controller;

import com.example.shared.User;
import com.example.producer_app.service.UserProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserProducer userProducer;

    public UserController(UserProducer userProducer) {
        this.userProducer = userProducer;
    }

    @PostMapping
    public ResponseEntity<String> sendUser(@RequestBody User user) {
        userProducer.sendMessage(user);
        return ResponseEntity.ok("User sent to Kafka");
    }
}
