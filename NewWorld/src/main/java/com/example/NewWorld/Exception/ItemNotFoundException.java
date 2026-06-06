package com.example.NewWorld.Exception;

public class ItemNotFoundException extends RuntimeException{
    public ItemNotFoundException(String errorMessage){
        super(errorMessage);
    }
}
