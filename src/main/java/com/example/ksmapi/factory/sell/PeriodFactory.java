package com.example.ksmapi.factory.sell;

import com.example.ksmapi.domain.sell.Period;
import com.example.ksmapi.util.GenericHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PeriodFactory {
    private final GenericHelper genericHelper;

    @Autowired
    public PeriodFactory(GenericHelper genericHelper) {
        this.genericHelper = genericHelper;
    }

    public Period getPeriodObject(String period, String description){
        return Period.builder()
                .id(genericHelper.getId(PeriodFactory.class))
                .period(period)
                .description(description).build();
    }
}
