package com.example.ksmapi.service.ingredient.impl;

import com.example.ksmapi.domain.ingredient.IngredientEntry;
import com.example.ksmapi.repository.ingredient.IngredientEntryRepository;
import com.example.ksmapi.service.ingredient.IngredientEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class IngredientEntryServiceImpl implements IngredientEntryService {
    private final IngredientEntryRepository repository;

    @Autowired
    public IngredientEntryServiceImpl(IngredientEntryRepository repository) {
        this.repository = repository;
    }

    @Override
    public IngredientEntry save(IngredientEntry ingredientEntry) {
        return repository.save(ingredientEntry);
    }

    @Override
    public IngredientEntry read(String id) {
        Optional<IngredientEntry> ingredientEntry = repository.findById(id);
        return ingredientEntry.orElse(null);
    }

    @Override
    public Boolean delete(String id) {
        IngredientEntry ingredientEntry = read(id);
        if(ingredientEntry!=null){
            repository.delete(ingredientEntry);
            return true;
        }
        return false;
    }

    @Override
    public List<IngredientEntry> readAll() {
        return repository.findAll();
    }

    @Override
    public List<IngredientEntry> findAllByIngredientId(String ingredientId) {
        return repository.findAllByIngredientId(ingredientId);
    }

    @Override
    public List<IngredientEntry> findAllByEntryId(String entryId) {
        return repository.findAllByEntryId(entryId);
    }

    @Override
    public List<IngredientEntry> findAllByDate(LocalDate localDate) {
        return repository.findAllByDate(localDate);
    }

    @Override
    public List<IngredientEntry> findAllByOrderByDate() {
        return repository.findAllByOrderByDate();
    }
}
