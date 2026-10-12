package com.fazon.haristech.service;

import lombok.*;
import org.springframework.stereotype.Service;

import com.fazon.haristech.Entity.*;
import com.fazon.haristech.model.*;
import com.fazon.haristech.repository.*;

import java.util.*;

@AllArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public UserEntity createUser(CreateUserRequest createUserRequest) {

        UserEntity user = new UserEntity();
        Optional<UserEntity> oldUser = userRepository.findByEmail(createUserRequest.getEmail());
        if (oldUser.isPresent()) {
            throw new RuntimeException("Email already exists");
        }
        user.setEmail(createUserRequest.getEmail());
        user.setPassword(createUserRequest.getPassword());
        user.setFirstName(createUserRequest.getFirstName());
        user.setLastName(createUserRequest.getLastName());
        user.setUsername(generateUsername(createUserRequest.getFirstName(), createUserRequest.getLastName()));
        return userRepository.save(user);
    }

    public UserEntity login(LoginUserRequest loginUserRequest) {
        Optional<UserEntity> userEntity = userRepository.findByEmailAndPassword(loginUserRequest.getEmail(), loginUserRequest.getPassword());
        if (userEntity.isPresent()){
            return userEntity.get();
        }
        throw new RuntimeException("User not found");
    }

    public UserEntity getUserByEmail(String email) {
        Optional<UserEntity> user = userRepository.findByEmail(email);
        if (user.isPresent()){
            return user.get();
        }
        throw new RuntimeException("User not found");
    }
    private String generateUsername(String firstName, String lastName) {
        int randomNum = (int)(Math.random() * 9000) + 1000;
        return firstName + lastName + randomNum;
    }
}
