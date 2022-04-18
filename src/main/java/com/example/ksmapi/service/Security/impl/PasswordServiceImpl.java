package com.example.ksmapi.service.Security.impl;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordServiceImpl {
    public String encryptPassword(String password){
        return new BCryptPasswordEncoder().encode(password);
    }

    public boolean isPasswordMatch(String raw, String encoded) {
        return new BCryptPasswordEncoder().matches(raw, encoded);
    }
}
