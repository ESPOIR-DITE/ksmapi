package com.example.ksmapi.service.item;

import com.example.ksmapi.domain.item.ItemIngredient;
import com.example.ksmapi.service.ServiceInterface;

import java.util.List;

public interface ItemIngredientService extends ServiceInterface<ItemIngredient,String> {
    List<ItemIngredient> findAllByEntryId(String entryId);
    List<ItemIngredient> findAllByIngredientId(String entryId);
    List<ItemIngredient> findAllByOrderByQuantity();
}
