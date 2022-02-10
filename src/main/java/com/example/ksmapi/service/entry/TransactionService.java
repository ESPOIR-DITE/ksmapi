package com.example.ksmapi.service.entry;

import com.example.ksmapi.domain.entry.Transaction;
import com.example.ksmapi.service.ServiceInterface;

import java.time.LocalDate;
import java.util.List;

public interface TransactionService extends ServiceInterface<Transaction,String> {
    List<Transaction> readAllByDate(LocalDate date);
    List<Transaction> readAllBySupplier(String supplier);
}
