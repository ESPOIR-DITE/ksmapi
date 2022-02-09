package com.example.ksmapi.factory;

import com.example.ksmapi.domain.entry.Entry;
import com.example.ksmapi.util.GenericHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class EntryFactory {
    private GenericHelper genericHelper;

    @Autowired
    public EntryFactory(GenericHelper genericHelper) {
        this.genericHelper = genericHelper;
    }

    public Entry getEntryObject(LocalDate date, double amount, String supplier){
        if(amount==0.0&&supplier.equals("")) return null;
        return Entry.builder()
                .date(date)
                .amount(amount)
                .supplier(supplier)
                .id(genericHelper.getId(EntryFactory.class))
                .build();
    }
    public Entry getEntry(Entry entry){
        if(entry.getAmount()==0.0&&entry.getSupplier().equals("")) return null;
        return Entry.builder()
                .date(entry.getDate())
                .amount(entry.getAmount())
                .supplier(entry.getSupplier())
                .id(genericHelper.getId(EntryFactory.class))
                .build();
    }
}
