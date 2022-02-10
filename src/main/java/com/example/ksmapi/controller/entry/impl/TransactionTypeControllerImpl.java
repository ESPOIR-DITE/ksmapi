package com.example.ksmapi.controller.entry.impl;

import com.example.ksmapi.controller.ControllerInterface;
import com.example.ksmapi.domain.entry.Transaction;
import com.example.ksmapi.domain.entry.TransactionType;
import com.example.ksmapi.factory.entry.TransactionTypeFaculty;
import com.example.ksmapi.service.entry.impl.TransactionTypeServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/ksm/transaction-type/")
public class TransactionTypeControllerImpl implements ControllerInterface<TransactionType,String> {
    private final TransactionTypeServiceImpl service;
    private final TransactionTypeFaculty transactionTypeFaculty;

    public TransactionTypeControllerImpl(TransactionTypeServiceImpl service, TransactionTypeFaculty transactionTypeFaculty) {
        this.service = service;
        this.transactionTypeFaculty = transactionTypeFaculty;
    }

    @PostMapping("create")
    @Override
    public TransactionType save(@RequestBody TransactionType transactionType) {
        TransactionType transactionType1 = transactionTypeFaculty.getTransactionType(transactionType.getName());
        return service.save(transactionType1);
    }
    @PostMapping("update")
    @Override
    public TransactionType update(@RequestBody TransactionType transactionType) {
        return service.save(transactionType);
    }

    @GetMapping("read")
    @Override
    public TransactionType read(@RequestParam("id") String id) {
        return service.read(id);
    }
    @GetMapping("delete")
    @Override
    public boolean delete(@RequestParam("id") String id) {
        return service.delete(id);
    }

    @GetMapping("reads")
    @Override
    public List<TransactionType> readAll() {
        return service.readAll();
    }
}
