package com.example.ksmapi.controller.ingedient.impl;

import com.example.ksmapi.controller.ControllerInterface;
import com.example.ksmapi.controller.util.ResponseDeal;
import com.example.ksmapi.domain.ingredient.Ingredient;
import com.example.ksmapi.domain.ingredient.QuantityType;
import com.example.ksmapi.factory.ingredient.IngredientFactory;
import com.example.ksmapi.factory.ingredient.QuantityTypeFactory;
import com.example.ksmapi.service.ingredient.impl.IngredientServiceImpl;
import com.example.ksmapi.service.ingredient.impl.QuantityTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:1338")
@RequestMapping("/ksm/quantity-type/")

public class QuantityTypeControllerImpl implements ControllerInterface<QuantityType,String> {
    private final QuantityTypeServiceImpl service;
    private final QuantityTypeFactory factory;
    private final ResponseDeal responseDeal;

    @Autowired
    public QuantityTypeControllerImpl(QuantityTypeServiceImpl service, QuantityTypeFactory factory, ResponseDeal responseDeal) {
        this.service = service;
        this.factory = factory;
        this.responseDeal = responseDeal;
    }

    @PostMapping("create")
    @Override
    public ResponseEntity<QuantityType> save(@RequestBody QuantityType ingredient, HttpServletRequest request) {
        QuantityType ingredient1 = factory.getQuantityType(ingredient);
        QuantityType result =  service.save(ingredient1);
        if(result!=null)
            return responseDeal.successful(result);
        return responseDeal.fail();
    }

    @PostMapping("update")
    @Override
    public ResponseEntity<QuantityType> update(@RequestBody QuantityType ingredient, HttpServletRequest request) {
        QuantityType result = service.save(ingredient);
        if(result!=null)
            return responseDeal.successful(result);
        return responseDeal.fail();
    }
    @GetMapping("read")
    @Override
    public ResponseEntity<QuantityType> read(@RequestParam("id") String id, HttpServletRequest request) {
        QuantityType result = service.read(id);
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
    public ResponseEntity<List<QuantityType>> readAll(HttpServletRequest request) {
        List<QuantityType> result = service.readAll();
        if(result!=null)
            return responseDeal.successful(result);
        return responseDeal.fail();
    }
}
