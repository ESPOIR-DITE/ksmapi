package com.example.ksmapi.service.ingredient.impl;

import com.example.ksmapi.domain.ingredient.Ingredient;
import com.example.ksmapi.domain.ingredient.QuantityType;
import com.example.ksmapi.repository.ingredient.IngredientRepository;
import com.example.ksmapi.repository.ingredient.QuantityTypeRepository;
import com.example.ksmapi.service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuantityTypeServiceImpl implements ServiceInterface<QuantityType,String> {
    private final QuantityTypeRepository Repository;

    @Autowired
    public QuantityTypeServiceImpl(QuantityTypeRepository ingredientRepository) {
        this.Repository = ingredientRepository;
    }

    @Override
    public QuantityType save(QuantityType ingredient) {
        return Repository.save(ingredient);
    }

    @Override
    public QuantityType read(String id) {
        Optional<QuantityType> ingredientOptional = Repository.findById(id);
        return ingredientOptional.orElse(null);
    }

    @Override
    public Boolean delete(String id) {
        QuantityType ingredient = read(id);
        if(ingredient!=null){
            Repository.delete(ingredient);
            return true;
        }
        return false;
    }

    @Override
    public List<QuantityType> readAll() {
        return Repository.findAll();
    }
}
