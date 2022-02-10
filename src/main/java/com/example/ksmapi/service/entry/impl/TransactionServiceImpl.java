package com.example.ksmapi.service.entry.impl;

import com.example.ksmapi.domain.entry.Transaction;
import com.example.ksmapi.repository.entry.TransactionRepository;
import com.example.ksmapi.service.entry.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository repository;

    @Autowired
    public TransactionServiceImpl(TransactionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Transaction save(Transaction entry) {
        return repository.save(entry);
    }

    @Override
    public Transaction read(String id) {
        Optional<Transaction> entryOptional = repository.findById(id);
        return entryOptional.orElse(null);
    }

    @Override
    public Boolean delete(String id) {
        Transaction transaction = read(id);
        if(transaction !=null){
            repository.delete(transaction);
            return true;
        }
        return false;
    }

    @Override
    public List<Transaction> readAll() {
        return repository.findAll();
    }

    @Override
    public List<Transaction> readAllByDate(LocalDate date) {
        return repository.readAllByDate(date);
    }

    @Override
    public List<Transaction> readAllBySupplier(String supplier) {
        return repository.readAllBySupplier(supplier);
    }

    public List<Transaction> readAllByTransactionTypeId(String transactionId){
        return repository.readAllByTransactionTypeId(transactionId);
    }
}
