package com.example.ksmapi.factory.sell;

import com.example.ksmapi.domain.sell.Period;
import com.example.ksmapi.domain.sell.PeriodTask;
import com.example.ksmapi.util.GenericHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Date;

@Component
public class PeriodTaskFactory {
    private final GenericHelper genericHelper;

    @Autowired
    public PeriodTaskFactory(GenericHelper genericHelper) {
        this.genericHelper = genericHelper;
    }

    public PeriodTask getPeriodTaskObject(String period, Date date, LocalDate time, String description){
        return PeriodTask.builder()
                .id(genericHelper.getId(PeriodTaskFactory.class))
                .date(date)
                .time(time)
                .period(period)
                .description(description).build();
    }
}
