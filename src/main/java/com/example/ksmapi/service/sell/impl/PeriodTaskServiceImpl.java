package com.example.ksmapi.service.sell.impl;

import com.example.ksmapi.domain.sell.Period;
import com.example.ksmapi.domain.sell.PeriodTask;
import com.example.ksmapi.repository.sell.PeriodRepository;
import com.example.ksmapi.repository.sell.PeriodTaskRepository;
import com.example.ksmapi.service.sell.PeriodService;
import com.example.ksmapi.service.sell.PeriodTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PeriodTaskServiceImpl implements PeriodTaskService {
    private final PeriodTaskRepository repository;

    @Autowired
    public PeriodTaskServiceImpl(PeriodTaskRepository repository) {
        this.repository = repository;
    }

    @Override
    public PeriodTask save(PeriodTask period) {
        return repository.save(period);
    }

    @Override
    public PeriodTask read(String id) {
        Optional<PeriodTask> periodOptional = repository.findById(id);
        return periodOptional.orElse(null);
    }

    @Override
    public Boolean delete(String id) {
        PeriodTask period = read(id);
        if(period!=null){
            repository.deleteById(id);
            return true;
        }
        return false;
    }
    public List<PeriodTask> readAllByPeriod(String periodId){
        return repository.readAllByPeriod(periodId);
    }

    @Override
    public PeriodTask readByTimeAndPeriod(LocalDate date, String period) {
        return repository.readByTimeAndPeriod(date, period);
    }

    @Override
    public List<PeriodTask> readAll() {
        return repository.findAll();
    }
}
