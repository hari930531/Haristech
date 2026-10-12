package com.fazon.haristech.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fazon.haristech.Entity.UserEntity;
import com.fazon.haristech.model.LoginUserRequest;
import com.fazon.haristech.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping
@Slf4j
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public UserEntity login(@RequestBody LoginUserRequest loginUserRequest) {
        log.info("Login user API Executed");
        return userService.login(loginUserRequest);
    }

    @GetMapping("/health")
    public String health() {
        log.info("Health check api has been requested");
        return "Hello Everyone, you are watching Github actions Series. Im Healthy";
    }
}