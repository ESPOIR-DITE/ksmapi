package com.example.ksmapi.service.sell.impl;

import com.example.ksmapi.domain.sell.PeriodTask;
import com.example.ksmapi.factory.sell.PeriodTaskFactory;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
class PeriodTaskServiceImplTest {
    private PeriodTaskServiceImpl periodTaskService;
    private PeriodTaskFactory periodTaskFactory;

    @Autowired
    public PeriodTaskServiceImplTest(PeriodTaskServiceImpl periodTaskService, PeriodTaskFactory periodTaskFactory) {
        this.periodTaskService = periodTaskService;
        this.periodTaskFactory = periodTaskFactory;
    }

    @Test
    void save() {
        Date date = new Date(2022,04, 07);
        PeriodTask periodTask = periodTaskFactory.getPeriodTaskObject("PTF-32666733-2c20-4e30-9f23-77d900456ae3", "PF-f7ee8891-cbbc-45ba-979d-5a8788a8a2cb",date , LocalDate.of(2022,04,07), "auto created in Daily task");
        PeriodTask result = periodTaskService.save(periodTask);
        System.out.println(result);
    }

    @Test
    void read() {
    }

    @Test
    void delete() {
        List<PeriodTask> periodTaskList = periodTaskService.readAll();
        for (int i = 0; i < 13; i++) {
            periodTaskService.delete(periodTaskList.get(i).getId());
        }
//        for (PeriodTask periodTasks : periodTaskList) {
//            if(periodTasks.getPeriod().equals("Daily")){
//                PeriodTask periodTask = periodTaskFactory.getPeriodTaskObject(periodTasks.getId(),"PF-f7ee8891-cbbc-45ba-979d-5a8788a8a2cb",periodTasks.getDate(),periodTasks.getTime(),periodTasks.getDescription());
//                periodTaskService.save(periodTask);
//            }
//        }
    }

    @Test
    void readAllByPeriod() {
    }

    @Test
    void readByTimeAndPeriod() {
    }

    @Test
    void readAll() {
        List<PeriodTask> periodTaskList = periodTaskService.readAll();
        for (PeriodTask periodTasks : periodTaskList) {
            if(periodTasks.getPeriod().equals("Daily")){
                PeriodTask periodTask = periodTaskFactory.getPeriodTaskObject(periodTasks.getId(),"PF-f7ee8891-cbbc-45ba-979d-5a8788a8a2cb",periodTasks.getDate(),periodTasks.getTime(),periodTasks.getDescription());
                periodTaskService.save(periodTask);
            }
        }

    }
}