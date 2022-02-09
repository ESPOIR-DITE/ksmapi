package com.example.ksmapi.service.item.impl;

import com.example.ksmapi.domain.item.ItemIngredient;
import com.example.ksmapi.repository.item.ItemIngredientRepository;
import com.example.ksmapi.service.item.ItemIngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemIngredientServiceImpl implements ItemIngredientService {
    private final ItemIngredientRepository repository;

    @Autowired
    public ItemIngredientServiceImpl(ItemIngredientRepository repository) {
        this.repository = repository;
    }

    @Override
    public ItemIngredient save(ItemIngredient itemIngredient) {
        return repository.save(itemIngredient);
    }

    @Override
    public ItemIngredient read(String id) {
        Optional<ItemIngredient> itemIngredient = repository.findById(id);
        return itemIngredient.orElse(null);
    }

    @Override
    public Boolean delete(String id) {
        ItemIngredient ingredient = read(id);
        if(ingredient!=null){
            repository.delete(ingredient);
            return true;
        }
        return false;
    }

    @Override
    public List<ItemIngredient> readAll() {
        return repository.findAll();
    }

    @Override
    public List<ItemIngredient> findAllByEntryId(String entryId) {
        return repository.findAllByEntryId(entryId);
    }

    @Override
    public List<ItemIngredient> findAllByIngredientId(String ingredientId) {
        return repository.findAllByIngredientId(ingredientId);
    }

    @Override
    public List<ItemIngredient> findAllByOrderByQuantity() {
        return repository.findAllByOrderByQuantity();
    }
}
