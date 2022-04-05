package com.example.ksmapi.service.sell;

import com.example.ksmapi.domain.sell.SellPeriod;
import com.example.ksmapi.service.ServiceInterface;

import java.util.List;

public interface SellPeriodService extends ServiceInterface<SellPeriod,String> {
    List<SellPeriod> findAllByPeriodId(String periodId);
}
