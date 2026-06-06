package com.example.NewWorld.Exception;

public class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException(String errorMessage){
        super(errorMessage);
    }
}
