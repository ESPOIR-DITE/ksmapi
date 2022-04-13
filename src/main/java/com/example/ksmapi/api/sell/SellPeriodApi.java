package com.example.ksmapi.api.sell;

import com.example.ksmapi.controller.util.ResponseDeal;
import com.example.ksmapi.domain.sell.Period;
import com.example.ksmapi.domain.sell.PeriodTask;
import com.example.ksmapi.domain.sell.SellPeriod;
import com.example.ksmapi.enums.PeriodEnum;
import com.example.ksmapi.factory.sell.PeriodTaskFactory;
import com.example.ksmapi.factory.sell.SellPeriodFactory;
import com.example.ksmapi.service.sell.PeriodService;
import com.example.ksmapi.service.sell.PeriodTaskService;
import com.example.ksmapi.service.sell.SellPeriodService;
import com.example.ksmapi.service.sell.impl.PeriodServiceImpl;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Component
public class SellPeriodApi {
    private SellPeriodService sellPeriodService;
    private SellPeriodFactory sellFactory;
    private PeriodServiceImpl periodService;
    private PeriodTaskService periodTaskService;
    private PeriodTaskFactory periodTaskFactory;

    public SellPeriodApi(SellPeriodService sellPeriodService, SellPeriodFactory sellFactory,
                         PeriodServiceImpl periodService,
                         PeriodTaskService periodTaskService, PeriodTaskFactory periodTaskFactory) {
        this.sellPeriodService = sellPeriodService;
        this.sellFactory = sellFactory;
        this.periodService = periodService;
        this.periodTaskService = periodTaskService;
        this.periodTaskFactory = periodTaskFactory;
    }

    @Scheduled(fixedDelay = 1,timeUnit = TimeUnit.DAYS)
    private void createDailySellPeriodTask(){
        Period period = periodService.readByName(PeriodEnum.DAILY.VALUE);
        if(period!=null){
            PeriodTask periodTask = periodTaskFactory.getPeriodTaskObject(period.getId(),new Date(), LocalDate.now(),"auto created in Daily task");
            periodTaskService.save(periodTask);
            System.out.println(new Date()+"  created Daily Period Task");
        }else{
            System.out.println(new Date()+"  could not create Daily Period Task");
        }
    }
    //Todo we should link all of the tasks of this week into a weekPeriodTask.
    @Scheduled(fixedDelay = 7,timeUnit = TimeUnit.DAYS)
    private void createWeeklySellPeriodTask(){
        Period period = periodService.readByName(PeriodEnum.WEEKLY.VALUE);
        if(period!=null){
            PeriodTask periodTask = periodTaskFactory.getPeriodTaskObject(period.getId(),new Date(), LocalDate.now(),"auto created in Weekly task");
            periodTaskService.save(periodTask);
            System.out.println(new Date()+"  created Weekly Period Task");
        }else{
            System.out.println(new Date()+"  could not create Weekly Period Task");
        }
    }
    @Scheduled(fixedDelay = 30,timeUnit = TimeUnit.DAYS)
    private void createMonthlySellPeriodTask(){
        Period period = periodService.readByName(PeriodEnum.MONTHLY.VALUE);
        if(period!=null){
            PeriodTask periodTask = periodTaskFactory.getPeriodTaskObject(period.getId(),new Date(), LocalDate.now(),"auto created in Weekly task");
            periodTaskService.save(periodTask);
            System.out.println(new Date()+"  created Weekly Period Task");
        }else{
            System.out.println(new Date()+"  could not create Weekly Period Task");
        }
    }
}
