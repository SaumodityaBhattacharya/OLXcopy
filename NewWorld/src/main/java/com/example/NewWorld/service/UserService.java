package com.example.NewWorld.service;

import com.example.NewWorld.Exception.AgeVerificationException;
import com.example.NewWorld.Exception.UserAlreadyExistsException;
import com.example.NewWorld.entity.Role;
import com.example.NewWorld.entity.User;
import com.example.NewWorld.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(User user) {
        if(user.getRole()== Role.SELLER){
            int age= Period.between(user.getDob(),
                            LocalDate.now())
                    .getYears();
            if(age<18){
                throw new AgeVerificationException("Seller must be 18 yrs old or above " +age);
            }
        }
        if (user.getUserEmail() != null && userRepository.findByUserEmail(user.getUserEmail()).isPresent()) {
            throw new UserAlreadyExistsException("Email ID already exists");
        }

        if (user.getUserPhoneNumber() != null && userRepository.findByUserPhoneNumber(user.getUserPhoneNumber()).isPresent()){
            throw new UserAlreadyExistsException("Phone Number already exists");
    }
    return userRepository.save(user);
}
}
