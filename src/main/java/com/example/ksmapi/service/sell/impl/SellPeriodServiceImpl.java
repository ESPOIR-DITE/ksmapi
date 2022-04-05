package com.example.ksmapi.service.sell.impl;

import com.example.ksmapi.domain.sell.SellPeriod;
import com.example.ksmapi.repository.sell.SellPeriodRepository;
import com.example.ksmapi.service.sell.SellPeriodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class SellPeriodServiceImpl implements SellPeriodService {
    private final SellPeriodRepository repository;

    @Autowired
    public SellPeriodServiceImpl(SellPeriodRepository repository) {
        this.repository = repository;
    }

    @Override
    public SellPeriod save(SellPeriod sellPeriod) {
        return repository.save(sellPeriod);
    }

    @Override
    public SellPeriod read(String id) {
        Optional<SellPeriod> sellPeriodOptional = repository.findById(id);
        return sellPeriodOptional.orElse(null);
    }

    @Override
    public Boolean delete(String id) {
        SellPeriod sellPeriod = read(id);
        if(sellPeriod!=null){
            repository.delete(sellPeriod);
            return true;
        }
        return false;
    }

    @Override
    public List<SellPeriod> readAll() {
        return repository.findAll();
    }

    @Override
    public List<SellPeriod> findAllByPeriodId(String periodId) {
        return repository.findAllByPeriodId(periodId);
    }
}
