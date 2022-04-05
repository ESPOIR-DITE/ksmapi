package com.example.ksmapi.controller.sell.impl;

import com.example.ksmapi.controller.ControllerInterface;
import com.example.ksmapi.controller.util.ResponseDeal;
import com.example.ksmapi.domain.sell.Period;
import com.example.ksmapi.factory.sell.PeriodFactory;
import com.example.ksmapi.service.sell.PeriodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
@RestController
@CrossOrigin(origins="http://localhost:1338")
@RequestMapping("/ksm/period/")
public class PeriodControllerImpl implements ControllerInterface<Period,String> {
    private final PeriodService service;
    private final PeriodFactory factory;
    private final ResponseDeal responseDeal;
    @Autowired
    public PeriodControllerImpl(PeriodService service, PeriodFactory factory,ResponseDeal responseDeal) {
        this.service = service;
        this.factory = factory;
        this.responseDeal = responseDeal;
    }

    @PostMapping("create")
    @Override
    public ResponseEntity<Period> save(@RequestBody Period period, HttpServletRequest request) {
        Period period1 = factory.getPeriodObject(period.getPeriod(),period.getDescription());
        Period result = service.save(period1);
        if(result!=null)
            return responseDeal.successful(result);
        return responseDeal.fail();
    }

    @PostMapping("update")
    @Override
    public ResponseEntity<Period> update(@RequestBody Period period, HttpServletRequest request) {
        Period result = service.save(period);
        if(result!=null)
            return responseDeal.successful(result);
        return responseDeal.fail();
    }

    @GetMapping("read")
    @Override
    public ResponseEntity<Period> read(@RequestParam("id") String id, HttpServletRequest request) {
        Period result = service.read(id);
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
    public ResponseEntity<List<Period>> readAll(HttpServletRequest request) {
       List<Period> result = service.readAll();
        if(result!=null)
            return responseDeal.successful(result);
        return responseDeal.fail();
    }
}
