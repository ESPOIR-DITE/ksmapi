package com.example.ksmapi.service.item.impl;

import com.example.ksmapi.domain.item.BuyerType;
import com.example.ksmapi.repository.item.BuyerTypeRepository;
import com.example.ksmapi.service.ServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BuyerTypeServiceImpl implements ServiceInterface<BuyerType,String> {
    private final BuyerTypeRepository repository;

    public BuyerTypeServiceImpl(BuyerTypeRepository repository) {
        this.repository = repository;
    }

    @Override
    public BuyerType save(BuyerType buyerType) {
        return repository.save(buyerType);
    }

    @Override
    public BuyerType read(String id) {
        Optional<BuyerType> buyerType = repository.findById(id);
        return buyerType.orElse(null);
    }

    @Override
    public Boolean delete(String id) {
        BuyerType buyerType = read(id);
        if(buyerType!=null){
            repository.delete(buyerType);
            return true;
        }
        return false;
    }

    @Override
    public List<BuyerType> readAll() {
        return repository.findAll();
    }
}
