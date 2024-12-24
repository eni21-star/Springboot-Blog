package com.coen.demo.exceptions;

public class BadReqException extends CustomExceptions{
    private  String message;
    private int statusCode;
    public BadReqException(String message){
        super(message, 400);
        this.message = message;
        this.statusCode = 400;
    }
}
