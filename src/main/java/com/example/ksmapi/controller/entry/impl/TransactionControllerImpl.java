package com.example.ksmapi.controller.entry.impl;

import com.example.ksmapi.controller.entry.TransactionController;
import com.example.ksmapi.domain.entry.Transaction;
import com.example.ksmapi.factory.entry.TransactionFactory;
import com.example.ksmapi.service.entry.impl.TransactionServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/ksm/transaction/")
public class TransactionControllerImpl implements TransactionController {

    private final TransactionServiceImpl service;
    private final TransactionFactory transactionFactory;

    public TransactionControllerImpl(TransactionServiceImpl service, TransactionFactory transactionFactory) {
        this.service = service;
        this.transactionFactory = transactionFactory;
    }


    @PostMapping("create")
    @Override
    public Transaction save(@RequestBody Transaction transaction) {
        Transaction transaction1 = transactionFactory.getEntry(transaction);
        return service.save(transaction1);
    }

    @PostMapping("update")
    @Override
    public Transaction update(@RequestBody Transaction transaction) {
        return service.save(transaction);
    }
    @GetMapping("read")
    @Override
    public Transaction read(@RequestParam("id") String id) {
        return service.read(id);
    }
    @GetMapping("delete")
    @Override
    public boolean delete(@RequestParam("id") String id) {
        return service.delete(id);
    }
    @GetMapping("reads")
    @Override
    public List<Transaction> readAll() {
        return service.readAll();
    }
    @GetMapping("read-all-by-date")
    @Override
    public List<Transaction> readAllByDate(@RequestParam("date") LocalDate date) {
        return service.readAllByDate(date);
    }
    @GetMapping("read-all-by-supplier")
    @Override
    public List<Transaction> readAllBySupplier(@RequestParam("supplier") String supplier) {
        return service.readAllBySupplier(supplier);
    }
    @GetMapping("read-all-by-transactionId")
    @Override
    public List<Transaction> readAllByTransactionTypeId(@RequestParam("transactionId") String transactionId) {
        return service.readAllByTransactionTypeId(transactionId);
    }
}
