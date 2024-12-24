package com.coen.demo.dto;


import org.springframework.stereotype.Service;

public record AuthDto(
        String username,
        String email,
        String password
) {
}
