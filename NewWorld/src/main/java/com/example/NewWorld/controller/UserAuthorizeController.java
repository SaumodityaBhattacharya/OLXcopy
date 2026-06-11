package com.example.NewWorld.controller;

import com.example.NewWorld.Exception.AgeVerificationException;
import com.example.NewWorld.dto.UserLoginRequest;
import com.example.NewWorld.entity.User;
import com.example.NewWorld.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.NewWorld.dto.AgeVerificationRequest;
import java.time.LocalDate;
import java.time.Period;
import com.example.NewWorld.dto.UserLoginRequest;

@RestController
@RequestMapping("/UserAuthorize/api")
public class UserAuthorizeController {
    private final UserService userService;

    public UserAuthorizeController(UserService userService){
        this.userService=userService;
    }
    @PostMapping("/register/user")
    public User registerUser(@Valid @RequestBody User user){
        return userService.registerUser(user);
    }

    @PostMapping("/verify/seller-age")
    public String verifySellerAge(@RequestBody AgeVerificationRequest req){
        int age=Period.between(req.getDob(),
                        LocalDate.now())
                .getYears();
        if(age<18){
            throw new AgeVerificationException("Seller must be 18 yrs old or above " +age);
        }
        return "Age verified successfully" +age;
    }
    @PostMapping("/userLogin")
    public String LoginUser(@RequestBody UserLoginRequest request){
        return userService.userLogin(request);
    }

}
