package com.example.ksmapi.controller.ingedient.impl;

import com.example.ksmapi.controller.ingedient.IngredientTransactionController;
import com.example.ksmapi.controller.util.ResponseDeal;
import com.example.ksmapi.domain.ingredient.IngredientTransaction;
import com.example.ksmapi.factory.ingredient.IngredientTransactionFactory;
import com.example.ksmapi.service.ingredient.impl.IngredientTransactionServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.List;
@RestController
@CrossOrigin(origins="http://localhost:1338")
@RequestMapping("/ksm/ingredient-transaction/")
public class IngredientTransactionControllerImpl implements IngredientTransactionController {
    private IngredientTransactionServiceImpl service;
    private IngredientTransactionFactory factory;
    private final ResponseDeal responseDeal;

    @Autowired
    public IngredientTransactionControllerImpl(ResponseDeal responseDeal,IngredientTransactionServiceImpl service, IngredientTransactionFactory factory) {
        this.service = service;
        this.factory = factory;
        this.responseDeal = responseDeal;
    }

    @PostMapping("create")
    @Override
    public ResponseEntity<IngredientTransaction> save(@RequestBody IngredientTransaction ingredientTransaction, HttpServletRequest request) {
        IngredientTransaction ingredientTransaction1 = factory.getIngredientEntryObject(ingredientTransaction);
        IngredientTransaction result = service.save(ingredientTransaction1);
        if(result!=null)
            return responseDeal.successful(result);
        return responseDeal.fail();
    }

    @PostMapping("update")
    @Override
    public ResponseEntity<IngredientTransaction> update(@RequestBody IngredientTransaction ingredientTransaction, HttpServletRequest request) {
        IngredientTransaction result = service.save(ingredientTransaction);
        if(result!=null)
            return responseDeal.successful(result);
        return responseDeal.fail();
    }

    @GetMapping("read")
    @Override
    public ResponseEntity<IngredientTransaction> read(@RequestParam("id") String id, HttpServletRequest request) {
        IngredientTransaction result = service.read(id);
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
    public ResponseEntity<List<IngredientTransaction>> readAll(HttpServletRequest request) {
        List<IngredientTransaction> result = service.readAll();
        if(result!=null)
            return responseDeal.successful(result);
        return responseDeal.fail();
    }

    @GetMapping("reads-by-ingredient-id")
    @Override
    public ResponseEntity<List<IngredientTransaction>> findAllByIngredientId(@RequestParam("id") String ingredientId, HttpServletRequest request) {
        List<IngredientTransaction> result = service.findAllByIngredientId(ingredientId);
        if(result!=null)
            return responseDeal.successful(result);
        return responseDeal.fail();
    }
    @GetMapping("reads-by-entry-id")
    @Override
    public ResponseEntity<List<IngredientTransaction>> findAllByEntryId(@RequestParam("id") String entryId, HttpServletRequest request) {
        List<IngredientTransaction> result = service.findAllByEntryId(entryId);
        if(result!=null)
            return responseDeal.successful(result);
        return responseDeal.fail();
    }

    @GetMapping("reads-by-date")
    @Override
    public ResponseEntity<List<IngredientTransaction>> findAllByDate(@RequestParam("date") LocalDate localDate, HttpServletRequest request) {
        List<IngredientTransaction> result = service.findAllByDate(localDate);
        if(result!=null)
            return responseDeal.successful(result);
        return responseDeal.fail();
    }
    @GetMapping("reads-by-order-by-date")
    @Override
    public ResponseEntity<List<IngredientTransaction>> findAllByOrderByDate(HttpServletRequest request) {
        List<IngredientTransaction> result = service.findAllByOrderByDate();
        if(result!=null)
            return responseDeal.successful(result);
        return responseDeal.fail();
    }
}
