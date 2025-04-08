package com.example.consumer_app.controller;

import com.example.shared.User;
import com.example.consumer_app.service.UserConsumer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private final UserConsumer userConsumer;

    public UserController(UserConsumer userConsumer) {
        this.userConsumer = userConsumer;
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userConsumer.getReceivedUsers();
    }
}
