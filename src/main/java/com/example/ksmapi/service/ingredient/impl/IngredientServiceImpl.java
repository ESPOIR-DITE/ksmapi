package com.example.ksmapi.service.ingredient.impl;

import com.example.ksmapi.domain.ingredient.Ingredient;
import com.example.ksmapi.repository.ingredient.IngredientRepository;
import com.example.ksmapi.service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredientServiceImpl implements ServiceInterface<Ingredient,String> {
    private final IngredientRepository Repository;

    @Autowired
    public IngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.Repository = ingredientRepository;
    }

    @Override
    public Ingredient save(Ingredient ingredient) {
        return Repository.save(ingredient);
    }

    @Override
    public Ingredient read(String id) {
        Optional<Ingredient> ingredientOptional = Repository.findById(id);
        return ingredientOptional.orElse(null);
    }

    @Override
    public Boolean delete(String id) {
        Ingredient ingredient = read(id);
        if(ingredient!=null){
            Repository.delete(ingredient);
            return true;
        }
        return false;
    }

    @Override
    public List<Ingredient> readAll() {
        return Repository.findAll();
    }
}
