package com.example.ksmapi.service.user;

import com.example.ksmapi.domain.user.UserAccount;
import com.example.ksmapi.service.ServiceInterface;

public interface UserAccountService extends ServiceInterface<UserAccount,String> {
    UserAccount readByEmailAndPassword(String email,String password);
}
