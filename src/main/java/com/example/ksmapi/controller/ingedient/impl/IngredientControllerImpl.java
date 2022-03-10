package com.example.ksmapi.controller.ingedient.impl;

import com.example.ksmapi.controller.ControllerInterface;
import com.example.ksmapi.controller.util.ResponseDeal;
import com.example.ksmapi.domain.ingredient.Ingredient;
import com.example.ksmapi.factory.IngredientFactory;
import com.example.ksmapi.service.ingredient.impl.IngredientServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:1338")
@RequestMapping("/ksm/ingredient/")

public class IngredientControllerImpl implements ControllerInterface<Ingredient,String> {
    private final IngredientServiceImpl service;
    private final IngredientFactory factory;
    private final ResponseDeal responseDeal;

    @Autowired
    public IngredientControllerImpl(IngredientServiceImpl service, IngredientFactory factory, ResponseDeal responseDeal) {
        this.service = service;
        this.factory = factory;
        this.responseDeal = responseDeal;
    }

    @PostMapping("create")
    @Override
    public ResponseEntity<Ingredient> save(@RequestBody Ingredient ingredient, HttpServletRequest request) {
        Ingredient ingredient1 = factory.getIngredient(ingredient);
        Ingredient result =  service.save(ingredient1);
        if(result!=null)
            return responseDeal.successful(result);
        return responseDeal.fail();
    }

    @PostMapping("update")
    @Override
    public ResponseEntity<Ingredient> update(@RequestBody Ingredient ingredient, HttpServletRequest request) {
        Ingredient result = service.save(ingredient);
        if(result!=null)
            return responseDeal.successful(result);
        return responseDeal.fail();
    }
    @GetMapping("read")
    @Override
    public ResponseEntity<Ingredient> read(@RequestParam("id") String id, HttpServletRequest request) {
        Ingredient result = service.read(id);
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
    public ResponseEntity<List<Ingredient>> readAll(HttpServletRequest request) {
        List<Ingredient> result = service.readAll();
        if(result!=null)
            return responseDeal.successful(result);
        return responseDeal.fail();
    }
}
