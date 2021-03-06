package com.example.ksmapi.controller.item.impl;

import com.example.ksmapi.controller.item.SellPriceController;
import com.example.ksmapi.controller.util.ResponseDeal;
import com.example.ksmapi.domain.sell.SellPrice;
import com.example.ksmapi.factory.sell.SellPriceFactory;
import com.example.ksmapi.service.item.SellPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.List;


@RestController
@CrossOrigin(origins="http://localhost:1338")
@RequestMapping("ksm/sell-price/")
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
        SellPrice result = service.save(sellPrice1);
        if(result!=null)
            return responseDeal.successful(result);
        return responseDeal.fail();
    }
    @PostMapping("update")
    @Override
    public ResponseEntity<SellPrice> update(@RequestBody SellPrice sellPrice, HttpServletRequest request) {
        SellPrice result = service.save(sellPrice);
        if(result!=null)
            return responseDeal.successful(result);
        return responseDeal.fail();
    }
    @GetMapping("read")
    @Override
    public ResponseEntity<SellPrice> read(@RequestParam("id") String id, HttpServletRequest request) {
        SellPrice result = service.read(id);
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
    public ResponseEntity<List<SellPrice>> readAll(HttpServletRequest request) {
        List<SellPrice> result = service.readAll();
        if(result!=null)
            return responseDeal.successful(result);
        return responseDeal.fail();
    }
    @GetMapping("find-all-by-buyer-type-id-and-date")
    @Override
    public ResponseEntity<List<SellPrice>> findAllByBuyerTYpeIdAndDateOrderByPrice(@RequestParam("buyerTypeId") String buyerTypeId, @RequestParam("date") LocalDate date, HttpServletRequest request) {
        List<SellPrice> result = service.findAllByBuyerTYpeIdAndDateOrderByPrice(buyerTypeId, date);
        if(result!=null)
            return responseDeal.successful(result);
        return responseDeal.fail();
    }
    @GetMapping("find-all-by-buyer-type-id-and-is-active")
    @Override
    public ResponseEntity<List<SellPrice>> findAllByBuyerTYpeIdAndIsActive(@RequestParam("buyerId") String buyerId, @RequestParam("idActive") boolean isActive, HttpServletRequest request) {
        List<SellPrice> result = service.findAllByBuyerTYpeIdAndIsActive(buyerId, isActive);
        if(result!=null)
            return responseDeal.successful(result);
        return responseDeal.fail();
    }
    @GetMapping("find-all-by-item-and-is-active")
    @Override
    public ResponseEntity<List<SellPrice>> findAllByItemIdAndIsActive(@RequestParam("buyerId") String buyerId, @RequestParam("isActive") boolean isActive, HttpServletRequest request) {
        List<SellPrice> result = service.findAllByItemIdAndIsActive(buyerId, isActive);
        if(result!=null)
            return responseDeal.successful(result);
        return responseDeal.fail();
    }

    @GetMapping("find-all-by-item-id-and-buyer-type-id")
    @Override
    public ResponseEntity<List<SellPrice>> findAllByItemIdAndBuyerTYpeId(@RequestParam("itemId") String itemId, @RequestParam("buyerId") String buyerId, HttpServletRequest request) {
        List<SellPrice> result = service.findAllByItemIdAndBuyerTYpeId(itemId, buyerId);
        if(result!=null)
            return responseDeal.successful(result);
        return responseDeal.fail();
    }

    @GetMapping("find-by-item-and-buyer-type")
    @Override
    public ResponseEntity<SellPrice> findAllByItemIdAndBuyerTypeIdAndDateIsNearAndIsActive(@RequestParam("itemId") String itemId, @RequestParam("buyerId") String buyerId, HttpServletRequest request) {
        SellPrice result = service.findAllByItemIdAndBuyerTypeIdAndDateIsNearAndIsActive(itemId, buyerId);
        if(result!=null)
            return responseDeal.successful(result);
        return responseDeal.fail();
    }
    @GetMapping("find-all-by-item-id")
    @Override
    public ResponseEntity<List<SellPrice>> findAllByItemId(@RequestParam("itemId") String itemId, HttpServletRequest request) {
        List<SellPrice> result = service.findAllByItemId(itemId);
        if(result!=null)
            return responseDeal.successful(result);
        return responseDeal.fail();
    }
}
