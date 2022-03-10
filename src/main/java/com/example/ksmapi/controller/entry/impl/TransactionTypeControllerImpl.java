package com.example.ksmapi.controller.entry.impl;

import com.example.ksmapi.controller.ControllerInterface;
import com.example.ksmapi.controller.util.ResponseDeal;
import com.example.ksmapi.domain.entry.Transaction;
import com.example.ksmapi.domain.entry.TransactionType;
import com.example.ksmapi.factory.entry.TransactionTypeFaculty;
import com.example.ksmapi.service.entry.impl.TransactionTypeServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:1338")
@RequestMapping("/ksm/transaction-type/")
public class TransactionTypeControllerImpl implements ControllerInterface<TransactionType,String> {
    private final TransactionTypeServiceImpl service;
    private final TransactionTypeFaculty transactionTypeFaculty;
    private final ResponseDeal responseDeal;

    @Autowired
    public TransactionTypeControllerImpl(ResponseDeal responseDeal, TransactionTypeServiceImpl service, TransactionTypeFaculty transactionTypeFaculty) {
        this.service = service;
        this.transactionTypeFaculty = transactionTypeFaculty;
        this.responseDeal = responseDeal;
    }

    @PostMapping("create")
    @Override
    public ResponseEntity<TransactionType> save(@RequestBody TransactionType transactionType, HttpServletRequest request) {
        TransactionType transactionType1 = transactionTypeFaculty.getTransactionType(transactionType.getName());
        TransactionType result = service.save(transactionType1);
        if(result!=null)
            return responseDeal.successful(result);
        return responseDeal.fail();
    }
    @PostMapping("update")
    @Override
    public ResponseEntity<TransactionType> update(@RequestBody TransactionType transactionType,HttpServletRequest request) {
        TransactionType result = service.save(transactionType);
        if(result!=null)
            return responseDeal.successful(result);
        return responseDeal.fail();
    }

    @GetMapping("read")
    @Override
    public ResponseEntity<TransactionType> read(@RequestParam("id") String id, HttpServletRequest request) {
        TransactionType result = service.read(id);
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
    public ResponseEntity<List<TransactionType>> readAll(HttpServletRequest request) {
        List<TransactionType> result = service.readAll();
        if(result!=null)
            return responseDeal.successful(result);
        return responseDeal.fail();
    }
}
