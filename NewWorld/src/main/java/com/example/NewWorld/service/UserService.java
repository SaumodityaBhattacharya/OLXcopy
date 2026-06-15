package com.example.NewWorld.service;

import com.example.NewWorld.Exception.AgeVerificationException;
import com.example.NewWorld.Exception.UserAlreadyExistsException;
import com.example.NewWorld.dto.ForgotPasswordRequest;
import com.example.NewWorld.dto.UserLoginRequest;
import com.example.NewWorld.dto.VerifyOtpRequest;
import com.example.NewWorld.entity.Role;
import com.example.NewWorld.entity.User;
import com.example.NewWorld.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Optional;
import java.util.Random;

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
public String forgotPassword(ForgotPasswordRequest request){
    Optional<User> user;

    if(request.getUserEmail()!=null &&
            !request.getUserEmail().isBlank()){

        user=userRepository.findByUserEmail(
                request.getUserEmail());
    }
    else if(request.getUserPhoneNumber()!=null &&
            !request.getUserPhoneNumber().isBlank()){

        user=userRepository.findByUserPhoneNumber(
                request.getUserPhoneNumber());
    }
    else{
        return "Please enter valid email or phone number";
    }

    if(user.isEmpty()){
        return "User does not exist";
    }
    int otp = 100000 + new Random().nextInt(900000);
    User foundUser= user.get();
    foundUser.setResetOtp(otp);
    foundUser.setOtpGeneratedAt(LocalDateTime.now());
    userRepository.save(foundUser);
    return "User found"+otp;
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
public String verifyOtpRequest(VerifyOtpRequest req){
   Optional<User> user=userRepository.findByUserEmail(req.getUserEmail());
   if(user.isEmpty())
       return "User does not exist ";
   User foundUser=user.get();

    if(!foundUser.getResetOtp().equals(req.getOtp())) {
        return "Invalid OTP";
    }
    return "OTP Verified Successfully";
}


}
