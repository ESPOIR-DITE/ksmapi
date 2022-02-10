package com.example.ksmapi.factory.entry;

import com.example.ksmapi.domain.entry.Transaction;
import com.example.ksmapi.util.GenericHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class TransactionFactory {
    private GenericHelper genericHelper;

    @Autowired
    public TransactionFactory(GenericHelper genericHelper) {
        this.genericHelper = genericHelper;
    }

    public Transaction getEntryObject(LocalDate date, double amount, String supplier){
        if(amount==0.0&&supplier.equals("")) return null;
        return Transaction.builder()
                .date(date)
                .amount(amount)
                .supplier(supplier)
                .id(genericHelper.getId(TransactionFactory.class))
                .build();
    }
    public Transaction getEntry(Transaction entry){
        if(entry.getAmount()==0.0&&entry.getSupplier().equals("")) return null;
        return Transaction.builder()
                .date(entry.getDate())
                .amount(entry.getAmount())
                .supplier(entry.getSupplier())
                .id(genericHelper.getId(TransactionFactory.class))
                .build();
    }
}
