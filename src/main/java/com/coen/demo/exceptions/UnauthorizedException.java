package com.coen.demo.exceptions;

public class UnauthorizedException extends CustomExceptions{
    private  String message;
    private int statusCode;
    public UnauthorizedException(String message){
        super(message, 401);
        this.message = message;
        this.statusCode = 401;
    }
}
