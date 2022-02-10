package com.example.ksmapi.service.ingredient.impl;

import com.example.ksmapi.domain.ingredient.IngredientTransaction;
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
    public IngredientTransaction save(IngredientTransaction ingredientTransaction) {
        return repository.save(ingredientTransaction);
    }

    @Override
    public IngredientTransaction read(String id) {
        Optional<IngredientTransaction> ingredientEntry = repository.findById(id);
        return ingredientEntry.orElse(null);
    }

    @Override
    public Boolean delete(String id) {
        IngredientTransaction ingredientTransaction = read(id);
        if(ingredientTransaction !=null){
            repository.delete(ingredientTransaction);
            return true;
        }
        return false;
    }

    @Override
    public List<IngredientTransaction> readAll() {
        return repository.findAll();
    }

    @Override
    public List<IngredientTransaction> findAllByIngredientId(String ingredientId) {
        return repository.findAllByIngredientId(ingredientId);
    }

    @Override
    public List<IngredientTransaction> findAllByEntryId(String entryId) {
        return repository.findAllByEntryId(entryId);
    }

    @Override
    public List<IngredientTransaction> findAllByDate(LocalDate localDate) {
        return repository.findAllByDate(localDate);
    }

    @Override
    public List<IngredientTransaction> findAllByOrderByDate() {
        return repository.findAllByOrderByDate();
    }
}
