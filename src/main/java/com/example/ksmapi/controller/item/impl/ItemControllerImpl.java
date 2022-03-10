package com.example.ksmapi.controller.item.impl;

import com.example.ksmapi.controller.item.ItemController;
import com.example.ksmapi.controller.util.ResponseDeal;
import com.example.ksmapi.controller.util.ResponseDealInterface;
import com.example.ksmapi.domain.item.Item;
import com.example.ksmapi.factory.item.ItemFactory;
import com.example.ksmapi.service.item.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
@RestController
@CrossOrigin(origins="http://localhost:1338")
@RequestMapping("kdm/item/")
public class ItemControllerImpl implements ItemController {
    private final ItemService itemService;
    private final ItemFactory itemFactory;
    private final ResponseDeal responseDeal;

    @Autowired
    public ItemControllerImpl(ItemService itemService, ItemFactory itemFactory, ResponseDeal responseDeal) {
        this.itemService = itemService;
        this.itemFactory = itemFactory;
        this.responseDeal = responseDeal;
    }

    @PostMapping("create")
    @Override
    public ResponseEntity<Item> save(@RequestBody Item item, HttpServletRequest request) {
        Item result = itemService.save(itemFactory.getItem(item));
        if(result!=null)
            return responseDeal.successful(result);
        return responseDeal.fail();
    }
    @PostMapping("update")
    @Override
    public ResponseEntity<Item> update(@RequestBody Item item, HttpServletRequest request) {
        Item result = itemService.save(item);
        if(result!=null)
            return responseDeal.successful(result);
        return responseDeal.fail();
    }
    @GetMapping("read")
    @Override
    public ResponseEntity<Item> read(@RequestParam("id") String id, HttpServletRequest request) {
        Item result = itemService.read(id);
        if(result!=null)
            return responseDeal.successful(result);
        return responseDeal.fail();
    }
    @GetMapping("delete")
    @Override
    public ResponseEntity<Boolean> delete(@RequestParam("id") String id, HttpServletRequest request) {
        boolean result = itemService.delete(id);
        if(result)
            return responseDeal.successful(result);
        return responseDeal.fail();
    }
    @GetMapping("reads")
    @Override
    public ResponseEntity<List<Item>> readAll(HttpServletRequest request) {
        List<Item> result =itemService.readAll();
        if(result!=null)
            return responseDeal.successful(result);
        return responseDeal.fail();
    }
}
