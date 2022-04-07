package com.example.ksmapi.controller.sell.impl;

import com.example.ksmapi.controller.ControllerInterface;
import com.example.ksmapi.controller.util.ResponseDeal;
import com.example.ksmapi.domain.sell.Period;
import com.example.ksmapi.domain.sell.PeriodTask;
import com.example.ksmapi.factory.sell.PeriodFactory;
import com.example.ksmapi.factory.sell.PeriodTaskFactory;
import com.example.ksmapi.service.sell.PeriodService;
import com.example.ksmapi.service.sell.PeriodTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:1338")
@RequestMapping("/ksm/period-task/")
public class PeriodTaskControllerImpl implements ControllerInterface<PeriodTask,String> {
    private final PeriodTaskService service;
    private final PeriodTaskFactory factory;
    private final ResponseDeal responseDeal;
    @Autowired
    public PeriodTaskControllerImpl(PeriodTaskService service, PeriodTaskFactory factory, ResponseDeal responseDeal) {
        this.service = service;
        this.factory = factory;
        this.responseDeal = responseDeal;
    }

    @PostMapping("create")
    @Override
    public ResponseEntity<PeriodTask> save(@RequestBody PeriodTask period, HttpServletRequest request) {
        PeriodTask period1 = factory.getPeriodTaskObject(period.getPeriod(),period.getDate(),period.getTime(),period.getDescription());
        PeriodTask result = service.save(period1);
        if(result!=null)
            return responseDeal.successful(result);
        return responseDeal.fail();
    }

    @PostMapping("update")
    @Override
    public ResponseEntity<PeriodTask> update(@RequestBody PeriodTask period, HttpServletRequest request) {
        PeriodTask result = service.save(period);
        if(result!=null)
            return responseDeal.successful(result);
        return responseDeal.fail();
    }

    @GetMapping("read")
    @Override
    public ResponseEntity<PeriodTask> read(@RequestParam("id") String id, HttpServletRequest request) {
        PeriodTask result = service.read(id);
        if(result!=null)
            return responseDeal.successful(result);
        return responseDeal.fail();
    }

    @GetMapping("delete")
    @Override
    public ResponseEntity<Boolean> delete(@RequestParam("id") String id, HttpServletRequest request) {
        Boolean result = service.delete(id);
        if(result)
            return responseDeal.successful(result);
        return responseDeal.fail();
    }

    @GetMapping("reads")
    @Override
    public ResponseEntity<List<PeriodTask>> readAll(HttpServletRequest request) {
       List<PeriodTask> result = service.readAll();
        if(result!=null)
            return responseDeal.successful(result);
        return responseDeal.fail();
    }
    @GetMapping("reads-by-period")
    public ResponseEntity<List<PeriodTask>> readAll(@RequestParam("periodId") String period, HttpServletRequest request) {
        List<PeriodTask> result = service.readAllByPeriod(period);
        if(result!=null)
            return responseDeal.successful(result);
        return responseDeal.fail();
    }
    @GetMapping("read-by-time-and-period")
    public ResponseEntity<PeriodTask> read(@RequestParam("time") LocalDate time, @RequestParam("period") String period, HttpServletRequest request) {
        PeriodTask result = service.readByTimeAndPeriod(time,period);
        if(result!=null)
            return responseDeal.successful(result);
        return responseDeal.fail();
    }

}
