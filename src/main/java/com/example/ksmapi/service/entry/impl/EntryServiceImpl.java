package com.example.ksmapi.service.entry.impl;

import com.example.ksmapi.domain.entry.Entry;
import com.example.ksmapi.repository.entry.EntryRepository;
import com.example.ksmapi.service.entry.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class EntryServiceImpl implements EntryService {
    private final EntryRepository repository;

    @Autowired
    public EntryServiceImpl(EntryRepository repository) {
        this.repository = repository;
    }

    @Override
    public Entry save(Entry entry) {
        return repository.save(entry);
    }

    @Override
    public Entry read(String id) {
        Optional<Entry> entryOptional = repository.findById(id);
        return entryOptional.orElse(null);
    }

    @Override
    public Boolean delete(String id) {
        Entry entry = read(id);
        if(entry!=null){
            repository.delete(entry);
            return true;
        }
        return false;
    }

    @Override
    public List<Entry> readAll() {
        return repository.findAll();
    }

    @Override
    public List<Entry> readAllByDate(LocalDate date) {
        return repository.readAllByDate(date);
    }

    @Override
    public List<Entry> readAllBySupplier(String supplier) {
        return repository.readAllBySupplier(supplier);
    }
}
