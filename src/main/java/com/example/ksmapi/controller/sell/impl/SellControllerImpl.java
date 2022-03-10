package com.example.ksmapi.controller.sell.impl;

import com.example.ksmapi.controller.sell.SellController;
import com.example.ksmapi.controller.util.ResponseDeal;
import com.example.ksmapi.domain.sell.Sell;
import com.example.ksmapi.factory.sell.SellFactory;
import com.example.ksmapi.service.sell.SellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:1338")
@RequestMapping("/ksm/sell/")
public class SellControllerImpl implements SellController {
    private final SellService service;
    private final SellFactory factory;
    private final ResponseDeal responseDeal;

    @Autowired
    public SellControllerImpl(SellService service, SellFactory factory, ResponseDeal responseDeal) {
        this.service = service;
        this.factory = factory;
        this.responseDeal = responseDeal;
    }

    @PostMapping("create")
    @Override
    public ResponseEntity<Sell> save(@RequestBody Sell sell, HttpServletRequest request) {
        Sell object = factory.getSell(sell);
        Sell result = service.save(object);
        if(result!=null)
            return responseDeal.successful(result);
        return responseDeal.fail();
    }

    @PostMapping("update")
    @Override
    public ResponseEntity<Sell> update(@RequestBody Sell sell, HttpServletRequest request) {
        Sell result = service.save(sell);
        if(result!=null)
            return responseDeal.successful(result);
        return responseDeal.fail();
    }
    @GetMapping("read")
    @Override
    public ResponseEntity<Sell> read(@RequestParam("id") String id, HttpServletRequest request) {
        Sell result = service.read(id);
        if(result!=null)
            return responseDeal.successful(result);
        return responseDeal.fail();
    }
    @GetMapping("delete")
    @Override
    public ResponseEntity<Boolean> delete(@RequestParam("id") String id, HttpServletRequest request) {
        boolean result = service.delete(id);
        if(result)
            return responseDeal.successful(result);
        return responseDeal.fail();
    }
    @GetMapping("reads")
    @Override
    public ResponseEntity<List<Sell>> readAll(HttpServletRequest request) {
        List<Sell> result = service.readAll();
        if(result!=null)
            return responseDeal.successful(result);
        return responseDeal.fail();
    }
    @GetMapping("find-all-by-customer-order-by-date")
    @Override
    public ResponseEntity<List<Sell>> findAllByCustomerIdOrderByDate(@RequestParam("customerId") String customerId, HttpServletRequest request) {
        List<Sell> result = service.findAllByCustomerIdOrderByDate(customerId);
        if(result!=null)
            return responseDeal.successful(result);
        return responseDeal.fail();
    }

    @GetMapping("find-all-by-item-id-date-after")
    @Override
    public ResponseEntity<List<Sell>> findAllByItemIdAndDateAfter(@RequestParam("itemId") String itemId, @RequestParam("date") Date date, HttpServletRequest request) {
        List<Sell> result = service.findAllByItemIdAndDateAfter(itemId,date);
        if(result!=null)
            return responseDeal.successful(result);
        return responseDeal.fail();
    }

    @GetMapping("find-all-by-buyer-type-id-order-by-date")
    @Override
    public ResponseEntity<List<Sell>> findAllByBuyerTypeIdOrderByDate(@RequestParam("buyerTypeId") String buyerTypeId, HttpServletRequest request) {
        List<Sell> result = service.findAllByBuyerTypeIdOrderByDate(buyerTypeId);
        if(result!=null)
            return responseDeal.successful(result);
        return responseDeal.fail();
    }
    @GetMapping("find-all-by-buyer-type-id-and-date-after")
    @Override
    public ResponseEntity<List<Sell>> findAllByBuyerTypeIdAndDateAfter(@RequestParam("buyerTypeId") String buyerTypeId, @RequestParam("date") Date date, HttpServletRequest request) {
        List<Sell> result = service.findAllByBuyerTypeIdAndDateAfter(buyerTypeId, date);
        if(result!=null)
            return responseDeal.successful(result);
        return responseDeal.fail();
    }
}
