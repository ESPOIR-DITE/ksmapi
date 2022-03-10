package com.example.ksmapi.controller.item.impl;

import com.example.ksmapi.controller.item.ItemIngredientController;
import com.example.ksmapi.controller.util.ResponseDeal;
import com.example.ksmapi.domain.item.ItemIngredient;
import com.example.ksmapi.factory.item.ItemIngredientFactory;
import com.example.ksmapi.service.item.ItemIngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:1338")
@RequestMapping("ksm/item-ingredient/")
public class ItemIngredientControllerImpl implements ItemIngredientController {
    private final ItemIngredientService service;
    private final ItemIngredientFactory factory;
    private final ResponseDeal responseDeal;

    @Autowired
    public ItemIngredientControllerImpl(ItemIngredientService service, ItemIngredientFactory factory, ResponseDeal responseDeal) {
        this.service = service;
        this.factory = factory;
        this.responseDeal = responseDeal;
    }

    @PostMapping("create")
    @Override
    public ResponseEntity<ItemIngredient> save(@RequestBody ItemIngredient itemIngredient, HttpServletRequest request) {
        ItemIngredient itemIngredientObject = factory.getItemIngredient(itemIngredient);
        ItemIngredient result = service.save(itemIngredientObject);
        if(result!=null)
            return responseDeal.successful(result);
        return responseDeal.fail();
    }
    @PostMapping("update")
    @Override
    public ResponseEntity<ItemIngredient> update(@RequestBody ItemIngredient itemIngredient, HttpServletRequest request) {
        ItemIngredient result = service.save(itemIngredient);
        if(result!=null)
            return responseDeal.successful(result);
        return responseDeal.fail();
    }
    @GetMapping("read")
    @Override
    public ResponseEntity<ItemIngredient> read(@RequestParam("id") String id, HttpServletRequest request) {
        ItemIngredient result = service.read(id);
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
    public ResponseEntity<List<ItemIngredient>> readAll(HttpServletRequest request) {
        List<ItemIngredient> result = service.readAll();
        if(result!=null)
            return responseDeal.successful(result);
        return responseDeal.fail();
    }
    @GetMapping("find-all-by-entry-id")
    @Override
    public ResponseEntity<List<ItemIngredient>> findAllByEntryId(@RequestParam("entryId") String entryId, HttpServletRequest request) {
        List<ItemIngredient> result = service.findAllByEntryId(entryId);
        if(result!=null)
            return responseDeal.successful(result);
        return responseDeal.fail();
    }
    @GetMapping("find-all-by-ingredient-id")
    @Override
    public ResponseEntity<List<ItemIngredient>> findAllByIngredientId(@RequestParam("entryId") String entryId, HttpServletRequest request) {
        List<ItemIngredient> result = service.findAllByIngredientId(entryId);
        if(result!=null)
            return responseDeal.successful(result);
        return responseDeal.fail();
    }

    @GetMapping("find-all-by-order-by-quantity")
    @Override
    public ResponseEntity<List<ItemIngredient>> findAllByOrderByQuantity(HttpServletRequest request) {
        List<ItemIngredient> result = service.findAllByOrderByQuantity();
        if(result!=null)
            return responseDeal.successful(result);
        return responseDeal.fail();
    }
}
