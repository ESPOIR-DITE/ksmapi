package com.example.ksmapi.controller.entry;

import com.example.ksmapi.controller.ControllerInterface;
import com.example.ksmapi.domain.entry.Transaction;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.List;

public interface TransactionController extends ControllerInterface<Transaction,String> {
    ResponseEntity<List<Transaction>> readAllByDate(LocalDate date, HttpServletRequest request);
    ResponseEntity<List<Transaction>> readAllBySupplier(String supplier, HttpServletRequest request);
    ResponseEntity<List<Transaction>> readAllByTransactionTypeId(String transactionId, HttpServletRequest request);
}
