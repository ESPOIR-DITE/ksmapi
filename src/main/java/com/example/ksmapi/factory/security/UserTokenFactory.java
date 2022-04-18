package com.example.ksmapi.factory.security;

import com.example.ksmapi.domain.security.UserToken;
import org.springframework.stereotype.Component;

@Component
public class UserTokenFactory{
    public UserToken getUserToken(String email, String token){
        if(email.equals("")&&token.equals("")) return null;
        return UserToken.builder()
                .token(token)
                .email(email).build();
    }
}
