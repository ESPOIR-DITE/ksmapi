package com.example.ksmapi.controller.item.impl;

import com.example.ksmapi.controller.item.SellPriceController;
import com.example.ksmapi.controller.util.ResponseDeal;
import com.example.ksmapi.domain.sell.SellPrice;
import com.example.ksmapi.factory.item.SellPriceFactory;
import com.example.ksmapi.service.item.SellPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("kdm/sell-price/")
public class SellPriceControllerImpl implements SellPriceController {
    private final SellPriceFactory factory;
    private final SellPriceService service;
    private final ResponseDeal responseDeal;

    @Autowired
    public SellPriceControllerImpl(SellPriceFactory factory, SellPriceService service, ResponseDeal responseDeal) {
        this.factory = factory;
        this.service = service;
        this.responseDeal = responseDeal;
    }
    @PostMapping("create")
    @Override
    public ResponseEntity<SellPrice> save(@RequestBody SellPrice sellPrice, HttpServletRequest request) {
        SellPrice sellPrice1 = factory.getSellPrice(sellPrice);
        var result = service.save(sellPrice1);
        if(result!=null)
            return responseDeal.successful(result);
        return responseDeal.fail();
    }
    @PostMapping("update")
    @Override
    public ResponseEntity<SellPrice> update(@RequestBody SellPrice sellPrice, HttpServletRequest request) {
        var result = service.save(sellPrice);
        if(result!=null)
            return responseDeal.successful(result);
        return responseDeal.fail();
    }
    @GetMapping("read")
    @Override
    public ResponseEntity<SellPrice> read(@RequestParam("id") String id, HttpServletRequest request) {
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
    public ResponseEntity<List<SellPrice>> readAll(HttpServletRequest request) {
        var result = service.readAll();
        if(result!=null)
            return responseDeal.successful(result);
        return responseDeal.fail();
    }
    @GetMapping("find-all-by-buyer-type-id-and-date")
    @Override
    public ResponseEntity<List<SellPrice>> findAllByBuyerTYpeIdAndDateOrderByPrice(@RequestParam("buyerTypeId") String buyerTypeId, @RequestParam("date") LocalDate date, HttpServletRequest request) {
        var result = service.findAllByBuyerTYpeIdAndDateOrderByPrice(buyerTypeId, date);
        if(result!=null)
            return responseDeal.successful(result);
        return responseDeal.fail();
    }
    @GetMapping("find-all-by-buyer-type-id-and-is-active")
    @Override
    public ResponseEntity<List<SellPrice>> findAllByBuyerTYpeIdAndIsActive(@RequestParam("buyerId") String buyerId, @RequestParam("idActive") boolean isActive, HttpServletRequest request) {
        var result = service.findAllByBuyerTYpeIdAndIsActive(buyerId, isActive);
        if(result!=null)
            return responseDeal.successful(result);
        return responseDeal.fail();
    }
    @GetMapping("find-all-by-item-and-is-active")
    @Override
    public ResponseEntity<List<SellPrice>> findAllByItemIdAndIsActive(@RequestParam("buyerId") String buyerId, @RequestParam("isActive") boolean isActive, HttpServletRequest request) {
        var result = service.findAllByItemIdAndIsActive(buyerId, isActive);
        if(result!=null)
            return responseDeal.successful(result);
        return responseDeal.fail();
    }

    @GetMapping("find-all-by-item-id-and-buyer-type-id")
    @Override
    public ResponseEntity<List<SellPrice>> findAllByItemIdAndBuyerTYpeId(@RequestParam("itemId") String itemId, @RequestParam("buyerId") String buyerId, HttpServletRequest request) {
        var result = service.findAllByItemIdAndBuyerTYpeId(itemId, buyerId);
        if(result!=null)
            return responseDeal.successful(result);
        return responseDeal.fail();
    }
}
