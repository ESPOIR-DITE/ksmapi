package com.example.ksmapi.controller.sell.impl;

import com.example.ksmapi.controller.sell.SellPeriodController;
import com.example.ksmapi.controller.util.ResponseDeal;
import com.example.ksmapi.domain.sell.SellPeriod;
import com.example.ksmapi.factory.sell.SellPeriodFactory;
import com.example.ksmapi.service.sell.SellPeriodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
@RestController
@CrossOrigin(origins="http://localhost:1338")
@RequestMapping("/ksm/period-sell/")
public class SellPeriodControllerImpl implements SellPeriodController {
    private final SellPeriodService service;
    private final SellPeriodFactory factory;
    private final ResponseDeal responseDeal;

    @Autowired
    public SellPeriodControllerImpl(SellPeriodService service, SellPeriodFactory factory, ResponseDeal responseDeal) {
        this.service = service;
        this.factory = factory;
        this.responseDeal = responseDeal;
    }

    @PostMapping("create")
    @Override
    public ResponseEntity<SellPeriod> save(@RequestBody SellPeriod sellPeriod, HttpServletRequest request) {
       SellPeriod object = factory.getSellPeriod(sellPeriod.getPeriodId(),sellPeriod.getSellId(),sellPeriod.getAmount(),sellPeriod.getDescription(),sellPeriod.getDate());
       SellPeriod result = service.save(object);
        if(result!=null)
            return responseDeal.successful(result);
        return responseDeal.fail();
    }

    @PostMapping("update")
    @Override
    public ResponseEntity<SellPeriod> update(@RequestBody SellPeriod sellPeriod, HttpServletRequest request) {
        SellPeriod result = service.save(sellPeriod);
        if(result!=null)
            return responseDeal.successful(result);
        return responseDeal.fail();
    }

    @GetMapping("read")
    @Override
    public ResponseEntity<SellPeriod> read(@RequestParam("id") String id, HttpServletRequest request) {
        SellPeriod result = service.read(id);
        if(result!=null)
            return responseDeal.successful(result);
        return responseDeal.fail();
    }

    @Override
    public ResponseEntity<Boolean> delete(String id, HttpServletRequest request) {
        Boolean result = service.delete(id);
        if(result)
            return responseDeal.successful(result);
        return responseDeal.fail();
    }

    @Override
    public ResponseEntity<List<SellPeriod>> readAll(HttpServletRequest request) {
        List<SellPeriod> result = service.readAll();
        if(result!=null)
            return responseDeal.successful(result);
        return responseDeal.fail();
    }

    @Override
    public ResponseEntity<List<SellPeriod>> findAllByPeriodId(String periodId, HttpServletRequest request) {
        List<SellPeriod> result = service.findAllByPeriodId(periodId);
        if(result!=null)
            return responseDeal.successful(result);
        return responseDeal.fail();
    }
}
