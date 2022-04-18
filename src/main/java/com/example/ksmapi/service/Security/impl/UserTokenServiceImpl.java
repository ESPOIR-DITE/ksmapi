package com.example.ksmapi.service.Security.impl;

import com.example.ksmapi.domain.security.UserToken;
import com.example.ksmapi.repository.security.UserTokenRepository;
import com.example.ksmapi.service.Security.UserTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserTokenServiceImpl implements UserTokenService {
    private final UserTokenRepository repository;

    @Autowired
    public UserTokenServiceImpl(UserTokenRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserToken save(UserToken userToken) {
        return repository.save(userToken);
    }

    @Override
    public UserToken read(String id) {
        Optional<UserToken> userTokenOptional = repository.findById(id);
        return userTokenOptional.orElse(null);
    }

    @Override
    public Boolean delete(String id) {
        UserToken userToken = read(id);
        if (userToken!=null){
            repository.delete(userToken);
            return true;
        }
        return false;
    }
    public void deleteAll(){
        repository.deleteAll();
    }

    @Override
    public List<UserToken> readAll() {
        return repository.findAll();
    }
}
