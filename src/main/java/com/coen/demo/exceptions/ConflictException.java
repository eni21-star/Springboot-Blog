package com.coen.demo.exceptions;

public class ConflictException extends CustomExceptions {
    private String message;
    private int statusCode;
    public ConflictException(String message) {
        super(message, 409);
        this.message = message;
        this.statusCode = 409;
    }
}
