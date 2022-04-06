package com.example.ksmapi.factory.sell;

import com.example.ksmapi.domain.sell.SellPeriod;
import com.example.ksmapi.util.GenericHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class SellPeriodFactory {
    private final GenericHelper genericHelper;

    @Autowired
    public SellPeriodFactory(GenericHelper genericHelper) {
        this.genericHelper = genericHelper;
    }
    public SellPeriod getSellPeriod(String periodId,String sellId, double quantity, String description, Date date){
        return SellPeriod.builder()
                .id(genericHelper.getId(SellPeriodFactory.class))
                .periodId(periodId)
                .sellId(sellId)
                .date(date)
                .description(description)
                .amount(quantity).build();
    }
}
