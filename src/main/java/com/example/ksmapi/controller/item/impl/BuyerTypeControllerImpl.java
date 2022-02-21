package com.example.ksmapi.controller.item.impl;

import com.example.ksmapi.controller.ControllerInterface;
import com.example.ksmapi.controller.util.ResponseDeal;
import com.example.ksmapi.domain.item.BuyerType;
import com.example.ksmapi.factory.item.BuyerTypeFactory;
import com.example.ksmapi.service.item.impl.BuyerTypeServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/ksm/buyer-type/")
public class BuyerTypeControllerImpl implements ControllerInterface<BuyerType, String> {
    private final BuyerTypeFactory factory;
    private final BuyerTypeServiceImpl service;
    private final ResponseDeal responseDeal;

    @Autowired
    public BuyerTypeControllerImpl(BuyerTypeFactory factory, BuyerTypeServiceImpl service, ResponseDeal responseDeal) {
        this.factory = factory;
        this.service = service;
        this.responseDeal = responseDeal;
    }

    @PostMapping("create")
    @Override
    public ResponseEntity<BuyerType> save(@RequestBody BuyerType buyerType, HttpServletRequest request) {
        var object = factory.getBuyer(buyerType);
        var result = service.save(object);
        if(result!=null)
            return responseDeal.successful(result);
        return responseDeal.fail();
    }
    @PostMapping("update")
    @Override
    public ResponseEntity<BuyerType> update(@RequestBody BuyerType buyerType, HttpServletRequest request) {
        var result = service.save(buyerType);
        if(result!=null)
            return responseDeal.successful(result);
        return responseDeal.fail();
    }
    @GetMapping("read")
    @Override
    public ResponseEntity<BuyerType> read(@RequestParam("id") String id, HttpServletRequest request) {
        var result = service.read(id);
        if(result!=null)
            return responseDeal.successful(result);
        return responseDeal.fail();
    }
    @GetMapping("delete")
    @Override
    public ResponseEntity<Boolean> delete(@RequestParam("id") String id, HttpServletRequest request) {
        var result = service.delete(id);
        if(result!=null)
            return responseDeal.successful(result);
        return responseDeal.fail();
    }
    @GetMapping("reads")
    @Override
    public ResponseEntity<List<BuyerType>> readAll(HttpServletRequest request) {
        var result = service.readAll();
        if(result!=null)
            return responseDeal.successful(result);
        return responseDeal.fail();
    }
}
