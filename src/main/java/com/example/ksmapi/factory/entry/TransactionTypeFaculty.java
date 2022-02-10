package com.example.ksmapi.factory.entry;

import com.example.ksmapi.domain.entry.TransactionType;
import com.example.ksmapi.util.GenericHelper;
import org.springframework.stereotype.Component;

@Component
public class TransactionTypeFaculty {
    private final GenericHelper genericHelper;

    public TransactionTypeFaculty(GenericHelper genericHelper) {
        this.genericHelper = genericHelper;
    }
    public TransactionType getTransactionType(String name){
        if(name.equals("")) return null;
        return TransactionType.builder()
                .id(this.genericHelper.getId(TransactionTypeFaculty.class))
                .name(name).build();
    }
}
