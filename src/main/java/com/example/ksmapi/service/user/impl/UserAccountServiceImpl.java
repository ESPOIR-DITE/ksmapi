package com.example.ksmapi.service.user.impl;

import com.example.ksmapi.domain.user.UserAccount;
import com.example.ksmapi.repository.user.UserAccountRepository;
import com.example.ksmapi.service.user.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserAccountServiceImpl implements UserAccountService {
    private final UserAccountRepository repository;

    @Autowired
    public UserAccountServiceImpl(UserAccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserAccount save(UserAccount userAccount) {
        return repository.save(userAccount);
    }

    @Override
    public UserAccount read(String id) {
        Optional<UserAccount> userAccount = repository.findById(id);
        return userAccount.orElse(null);
    }

    @Override
    public Boolean delete(String id) {
        UserAccount userAccount = read(id);
        if(userAccount!=null){
            repository.delete(userAccount);
            return true;
        }
        return false;
    }

    @Override
    public List<UserAccount> readAll() {
        return repository.findAll();
    }

    @Override
    public UserAccount readByEmailAndPassword(String email, String password) {
        return repository.readByEmailAndPassword(email,password);
    }
    public UserAccount readByEmailA(String email) {
        return repository.readByEmail(email);
    }
}
