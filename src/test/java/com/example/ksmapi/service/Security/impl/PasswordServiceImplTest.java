package com.example.ksmapi.service.Security.impl;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
class PasswordServiceImplTest {
 String password= "0000";
 String encodedPassword ="";
 private PasswordServiceImpl passwordService;

 @Autowired
    public PasswordServiceImplTest(PasswordServiceImpl passwordService) {
        this.passwordService = passwordService;
    }

    @Test
    void encryptPassword() {
      encodedPassword =  passwordService.encryptPassword(password);
        System.out.println(encodedPassword);
        assertTrue(passwordService.isPasswordMatch(password,encodedPassword));
    }

    @Test
    void isPasswordMatch() {
     assertTrue(passwordService.isPasswordMatch("0000","$2a$10$J9O6CXWxJFTkebhh2Y8yZ.sr/Sgs6GK9lQ8rip2KHXqTr/CXYZBkG"));
    }
}