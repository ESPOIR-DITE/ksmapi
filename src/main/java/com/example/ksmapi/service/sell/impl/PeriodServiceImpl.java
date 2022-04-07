package com.example.ksmapi.service.sell.impl;

import com.example.ksmapi.domain.sell.Period;
import com.example.ksmapi.repository.sell.PeriodRepository;
import com.example.ksmapi.service.sell.PeriodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeriodServiceImpl implements PeriodService {
    private final PeriodRepository repository;

    @Autowired
    public PeriodServiceImpl(PeriodRepository repository) {
        this.repository = repository;
    }

    @Override
    public Period save(Period period) {
        return repository.save(period);
    }

    @Override
    public Period read(String id) {
        Optional<Period> periodOptional = repository.findById(id);
        return periodOptional.orElse(null);
    }

    @Override
    public Boolean delete(String id) {
        Period period = read(id);
        if(period!=null){
            repository.deleteById(id);
            return true;
        }
        return false;
    }
    public Period readByName(String name){
        return repository.readByPeriod(name);
    }

    @Override
    public List<Period> readAll() {
        return repository.findAll();
    }
}
