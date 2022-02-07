package com.example.ksmapi.factory;

import com.example.ksmapi.domain.Entry;
import com.example.ksmapi.domain.GenericResponse;
import com.example.ksmapi.util.GenericHelper;
import com.example.ksmapi.util.StringHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EntryFactory {
    private GenericHelper genericHelper;

    @Autowired
    public EntryFactory(GenericHelper genericHelper) {
        this.genericHelper = genericHelper;
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
