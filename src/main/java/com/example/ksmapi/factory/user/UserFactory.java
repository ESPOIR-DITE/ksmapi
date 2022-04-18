package com.example.ksmapi.factory.user;

import com.example.ksmapi.domain.user.Users;
import com.example.ksmapi.util.GenericHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserFactory {
    private final GenericHelper genericHelper;

    @Autowired
    public UserFactory(GenericHelper genericHelper) {
        this.genericHelper = genericHelper;
    }

    public Users getUser(String email, String firstName, String middleName, String lastName){
        return Users.builder()
                .email(email)
                .firstName(firstName)
                .lastName(lastName)
                .middleName(middleName).build();
    }
}
