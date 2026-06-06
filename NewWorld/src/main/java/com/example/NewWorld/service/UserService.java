package com.example.NewWorld.service;

import com.example.NewWorld.entity.User;
import com.example.NewWorld.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(User user) {
        if (user.getUserEmail() != null && userRepository.findByUserEmail(user.getUserEmail()).isPresent()) {
            throw new RuntimeException("Email ID already exists");
        }

        if (user.getUserPhoneNumber() != null && userRepository.findByUserPhoneNumber(user.getUserPhoneNumber()).isPresent()){
            throw new RuntimeException("Phone Number already exists");
    }
    return userRepository.save(user);
}
}
