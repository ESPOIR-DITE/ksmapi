package com.example.ksmapi.service.ingredient;

import com.example.ksmapi.domain.ingredient.IngredientTransaction;
import com.example.ksmapi.service.ServiceInterface;

import java.time.LocalDate;
import java.util.List;

public interface IngredientEntryService extends ServiceInterface<IngredientTransaction,String> {
    List<IngredientTransaction> findAllByIngredientId(String ingredientId);
    List<IngredientTransaction> findAllByEntryId(String entryId);
    List<IngredientTransaction> findAllByDate(LocalDate localDate);
    List<IngredientTransaction> findAllByOrderByDate();
}
