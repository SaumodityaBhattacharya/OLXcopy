package com.example.NewWorld.Exception;

public class InvalidPriceException extends RuntimeException{
    public InvalidPriceException(String errorMessage){
        super(errorMessage);
    }
}
