package com.example.ksmapi.service.user.impl;

import com.example.ksmapi.domain.user.Users;
import com.example.ksmapi.repository.user.UserRepository;
import com.example.ksmapi.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public Users save(Users users) {
        return repository.save(users);
    }

    @Override
    public Users read(String id) {
        Optional<Users>optionalUser = repository.findById(id);
        return optionalUser.orElse(null);
    }

    @Override
    public Boolean delete(String id) {
       Users users = read(id);
       if(users !=null){
           repository.delete(users);
           return true;
       }
       return false;
    }

    @Override
    public List<Users> readAll() {
        return repository.findAll();
    }
}
