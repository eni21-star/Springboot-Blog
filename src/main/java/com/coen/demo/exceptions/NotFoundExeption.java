package com.coen.demo.exceptions;

public class NotFoundExeption extends CustomExceptions{
    private String message;
    private int statusCode;
    public NotFoundExeption(String message) {
        super(message, 404);
        this.message = message;
        this.statusCode = 404;
    }
}

