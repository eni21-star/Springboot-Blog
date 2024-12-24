package com.coen.demo.exceptions;

public class ForbiddenException extends  CustomExceptions{
    private String message;
    private int statusCode;
    public ForbiddenException(String message) {
        super(message, 403);
        this.message = message;
        this.statusCode = 403;
    }
}
