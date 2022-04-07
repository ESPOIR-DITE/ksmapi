package com.example.ksmapi.service.sell;

import com.example.ksmapi.domain.sell.Period;
import com.example.ksmapi.domain.sell.PeriodTask;
import com.example.ksmapi.service.ServiceInterface;

import java.time.LocalDate;
import java.util.List;

public interface PeriodTaskService extends ServiceInterface<PeriodTask,String> {
    List<PeriodTask> readAllByPeriod(String period);
    PeriodTask readByTimeAndPeriod(LocalDate date, String period);
}
