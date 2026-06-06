package com.example.NewWorld.controller;

import com.example.NewWorld.entity.User;
import com.example.NewWorld.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
