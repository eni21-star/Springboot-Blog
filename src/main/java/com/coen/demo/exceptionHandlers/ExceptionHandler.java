package com.coen.demo.exceptionHandlers;

import com.coen.demo.exceptions.CustomExceptions;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(CustomExceptions.class)
    public ResponseEntity<?> returnError(CustomExceptions error){
        return ResponseEntity
                .status(error.getStatusCode())
                .body(error.getMessage());
    }

}
