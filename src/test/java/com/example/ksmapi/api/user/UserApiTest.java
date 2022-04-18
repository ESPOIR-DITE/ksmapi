package com.example.ksmapi.api.user;

import com.example.ksmapi.domain.user.UserAccount;
import com.example.ksmapi.domain.user.UserDetails;
import com.example.ksmapi.domain.user.Users;
import com.example.ksmapi.factory.user.UserAccountFactory;
import com.example.ksmapi.factory.user.UserFactory;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
class UserApiTest {
    UserApi userApi;
    UserFactory userFactory;
    UserAccountFactory userAccountFactory;
    @Autowired
    public UserApiTest(UserApi userApi, UserFactory userFactory, UserAccountFactory userAccountFactory) {
        this.userApi = userApi;
        this.userFactory = userFactory;
        this.userAccountFactory = userAccountFactory;
    }

    @Test
    void register() {
        Users users = userFactory.getUser("exp@gmail.com","ex","","dit");
        UserAccount userAccount = userAccountFactory.getUserAccount("exp@gmail.com","09384","08434","0000",new Date(),true,"");
        UserDetails userDetails = UserDetails.builder().users(users).userAccount(userAccount).build();
        assertTrue(userApi.register(userDetails));
    }

    @Test
    void login() {
        System.out.println(userApi.login("exp@gmail.com","0000"));
    }

    @Test
    void logout() {
    }
}