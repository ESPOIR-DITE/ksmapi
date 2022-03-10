package com.example.ksmapi.controller.entry.impl;

import com.example.ksmapi.controller.entry.TransactionController;
import com.example.ksmapi.controller.util.ResponseDeal;
import com.example.ksmapi.domain.entry.Transaction;
import com.example.ksmapi.factory.entry.TransactionFactory;
import com.example.ksmapi.service.entry.impl.TransactionServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:1338")
@RequestMapping("/ksm/transaction/")
public class TransactionControllerImpl implements TransactionController {

    private final TransactionServiceImpl service;
    private final TransactionFactory transactionFactory;
    private final ResponseDeal responseDeal;

    @Autowired
    public TransactionControllerImpl(TransactionServiceImpl service, TransactionFactory transactionFactory, ResponseDeal responseDeal) {
        this.service = service;
        this.transactionFactory = transactionFactory;
        this.responseDeal = responseDeal;
    }


    @PostMapping("create")
    @Override
    public ResponseEntity<Transaction> save(@RequestBody Transaction transaction, HttpServletRequest request) {

        Transaction transaction1 = transactionFactory.getEntry(transaction);
        Transaction result = service.save(transaction1);
        if(result!=null)
            return responseDeal.successful(result);
        return responseDeal.fail();
    }

    @PostMapping("update")
    @Override
    public ResponseEntity<Transaction> update(@RequestBody Transaction transaction, HttpServletRequest request) {
        Transaction result =  service.save(transaction);
        if(result!=null)
            return responseDeal.successful(result);
        return responseDeal.fail();
    }
    @GetMapping("read")
    @Override
    public ResponseEntity<Transaction> read(@RequestParam("id") String id, HttpServletRequest request) {
        Transaction result = service.read(id);
        if(result!=null)
            return responseDeal.successful(result);
        return responseDeal.fail();
    }
    @GetMapping("delete")
    @Override
    public ResponseEntity<Boolean> delete(@RequestParam("id") String id, HttpServletRequest request) {
        boolean result = service.delete(id);
        if(result)
            return responseDeal.successful(result);
        return responseDeal.fail();
    }
    @GetMapping("reads")
    @Override
    public ResponseEntity<List<Transaction>> readAll(HttpServletRequest request) {
        List<Transaction> result =  service.readAll();
        if(result!=null)
            return responseDeal.successful(result);
        return responseDeal.fail();
    }
    @GetMapping("read-all-by-date")
    @Override
    public ResponseEntity<List<Transaction>> readAllByDate(@RequestParam("date") LocalDate date, HttpServletRequest request) {
        List<Transaction> result = service.readAllByDate(date);
        if(result!=null)
            return responseDeal.successful(result);
        return responseDeal.fail();
    }
    @GetMapping("read-all-by-supplier")
    @Override
    public ResponseEntity<List<Transaction>> readAllBySupplier(@RequestParam("supplier") String supplier, HttpServletRequest request) {
        List<Transaction> result = service.readAllBySupplier(supplier);
        if(result!=null)
            return responseDeal.successful(result);
        return responseDeal.fail();
    }
    @GetMapping("read-all-by-transactionId")
    @Override
    public ResponseEntity<List<Transaction>> readAllByTransactionTypeId(@RequestParam("transactionId") String transactionId, HttpServletRequest request) {
        List<Transaction> result = service.readAllByTransactionTypeId(transactionId);
        if(result!=null)
            return responseDeal.successful(result);
        return responseDeal.fail();
    }
}
