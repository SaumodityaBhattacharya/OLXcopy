package com.example.NewWorld.Exception;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ItemNotFoundException.class)
    public ResponseEntity<String> handleItemNotFound(
            ItemNotFoundException ex) {

        return new ResponseEntity<>(
                ex.getMessage(),
                HttpStatus.NOT_FOUND
        );
    }
    @ExceptionHandler(InvalidPriceException.class)
    public ResponseEntity<String> handleInvalidPrice(InvalidPriceException ex){
        return new ResponseEntity<>(
                ex.getMessage(),
        HttpStatus.BAD_REQUEST);
    }
}
