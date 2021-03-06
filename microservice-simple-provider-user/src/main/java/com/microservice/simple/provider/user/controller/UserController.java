package com.microservice.simple.provider.user.controller;

import com.microservice.simple.provider.user.dao.UserRepository;
import com.microservice.simple.provider.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    public Optional<User> findById(@PathVariable Long id) {
        Optional<User> user = userRepository.findById(id);
        return user;
    }
}
