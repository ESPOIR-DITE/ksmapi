package com.example.ksmapi.service.entry.impl;

import com.example.ksmapi.domain.entry.TransactionType;
import com.example.ksmapi.repository.entry.TransactionTypeRepository;
import com.example.ksmapi.service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionTypeServiceImpl implements ServiceInterface<TransactionType,String> {
    private final TransactionTypeRepository repository;

    @Autowired
    public TransactionTypeServiceImpl(TransactionTypeRepository repository) {
        this.repository = repository;
    }

    @Override
    public TransactionType save(TransactionType transactionType) {
        return repository.save(transactionType);
    }

    @Override
    public TransactionType read(String id) {
        Optional<TransactionType> result = repository.findById(id);
        return result.orElse(null);
    }

    @Override
    public Boolean delete(String id) {
        TransactionType transactionType = read(id);
        if(transactionType!=null){
            repository.delete(transactionType);
            return true;
        }
        return false;
    }

    @Override
    public List<TransactionType> readAll() {
        return repository.findAll();
    }
}
