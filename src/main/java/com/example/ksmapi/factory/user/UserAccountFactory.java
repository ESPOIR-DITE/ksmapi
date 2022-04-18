package com.example.ksmapi.factory.user;

import com.example.ksmapi.domain.user.UserAccount;
import com.example.ksmapi.service.Security.impl.PasswordServiceImpl;
import com.example.ksmapi.util.GenericHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class UserAccountFactory {
    private final GenericHelper genericHelper;
    private final PasswordServiceImpl passwordService;

    @Autowired
    public UserAccountFactory(GenericHelper genericHelper, PasswordServiceImpl passwordService) {
        this.genericHelper = genericHelper;
        this.passwordService = passwordService;
    }

        public  UserAccount getUserAccount(String email, String organizationId, String roleId, String password, Date date, boolean state, String description){
        if(email.equals("")&&password.equals("")) return null;
        return UserAccount.builder()
                .id(genericHelper.getId(UserAccount.class))
                .date(date)
                .password(passwordService.encryptPassword(password))
                .description(description)
                .email(email)
                .organizationId(organizationId)
                .roleId(roleId)
                .state(state)
                .build();
    }
}
