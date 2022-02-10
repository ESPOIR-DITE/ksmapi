package com.example.ksmapi.controller.entry;

import com.example.ksmapi.controller.ControllerInterface;
import com.example.ksmapi.domain.entry.Transaction;

import java.time.LocalDate;
import java.util.List;

public interface TransactionController extends ControllerInterface<Transaction,String> {
    List<Transaction> readAllByDate(LocalDate date);
    List<Transaction> readAllBySupplier(String supplier);
    List<Transaction> readAllByTransactionTypeId(String transactionId);
}
