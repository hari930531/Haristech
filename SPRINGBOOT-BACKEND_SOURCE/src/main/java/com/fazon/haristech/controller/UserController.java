package com.fazon.haristech.controller;

import lombok.*;
import lombok.extern.slf4j.*;
import org.springframework.web.bind.annotation.*;

import com.fazon.haristech.Entity.*;
import com.fazon.haristech.model.*;
import com.fazon.haristech.service.*;

@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
@Slf4j
public class UserController {
    private final UserService userService;

    @PostMapping
    public UserEntity createUser(@RequestBody CreateUserRequest createUserRequest) {
        log.info("Create user API Executed");
        return userService.createUser(createUserRequest);
    }

    @GetMapping("/{email}")
    public UserEntity getUser(@PathVariable String email) {
        log.info("Get user API Executed");
        return userService.getUserByEmail(email);
    }


}
