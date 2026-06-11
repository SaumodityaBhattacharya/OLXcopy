package com.example.NewWorld.service;

import com.example.NewWorld.Exception.AgeVerificationException;
import com.example.NewWorld.Exception.UserAlreadyExistsException;
import com.example.NewWorld.dto.UserLoginRequest;
import com.example.NewWorld.entity.Role;
import com.example.NewWorld.entity.User;
import com.example.NewWorld.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;

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
public String userLogin(UserLoginRequest request){
      Optional<User> user;
      if(request.getUserEmail()!=null && !request.getUserEmail().isBlank()){
          user=userRepository.findByUserEmail(request.getUserEmail());
      }
      else if(request.getUserPhoneNumber()!=null && !request.getUserPhoneNumber().isBlank()){
          user=userRepository.findByUserPhoneNumber((request.getUserPhoneNumber()));
      }
      else
          return "Please enter valid email or phone number ";

      if(user.isEmpty())
          return "User does not exist";
      User foundUser=user.get();
      if(!foundUser.getUserPassword().equals(request.getUserPassword())){
          return "Invalid Password";
      }
      else
          return "User logged in successfully";
}
}
