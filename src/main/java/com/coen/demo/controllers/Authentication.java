package com.coen.demo.controllers;

import com.coen.demo.dto.AuthDto;
import com.coen.demo.mapper.AuthRegMapper;
import com.coen.demo.services.AuthSerives;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/")
@RestController
public class Authentication {

    private final AuthSerives authSerives;

    public Authentication(AuthSerives authSerives) {
        this.authSerives = authSerives;
    }

    @PostMapping("register")
    public AuthRegMapper register(
            @RequestBody AuthDto author
            ){
        return authSerives.reg(author);
    }

}
