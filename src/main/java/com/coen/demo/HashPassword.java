package com.coen.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class HashPassword {
    private final BCryptPasswordEncoder bcrypt;

    HashPassword(BCryptPasswordEncoder bcrypt){
        this.bcrypt = bcrypt;
    }

    public String hashPassword(String password){
        return bcrypt.encode(password);
    }

    public boolean ComparePassword(String password, String dbPassword){
        return bcrypt.matches(password, dbPassword);
    }
}
