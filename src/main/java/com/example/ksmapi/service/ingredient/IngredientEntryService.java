package com.example.ksmapi.service.ingredient;

import com.example.ksmapi.domain.ingredient.IngredientEntry;
import com.example.ksmapi.service.ServiceInterface;

import java.time.LocalDate;
import java.util.List;

public interface IngredientEntryService extends ServiceInterface<IngredientEntry,String> {
    List<IngredientEntry> findAllByIngredientId(String ingredientId);
    List<IngredientEntry> findAllByEntryId(String entryId);
    List<IngredientEntry> findAllByDate(LocalDate localDate);
    List<IngredientEntry> findAllByOrderByDate();
}
