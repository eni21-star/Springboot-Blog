package com.coen.demo.exceptions;

public class CustomExceptions extends RuntimeException{
    private String message;
    private int statusCode;
    public CustomExceptions(String message, int statusCode) {
        super(message);
        this.message = message;
        this.statusCode = statusCode;
    }

    public int getStatusCode(){
        return  statusCode;
    }
}
