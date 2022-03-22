package com.example.ksmapi.factory.item;

import com.example.ksmapi.domain.item.ItemIngredient;
import com.example.ksmapi.util.GenericHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ItemIngredientFactory {
    private GenericHelper genericHelper;
    @Autowired
    public ItemIngredientFactory(GenericHelper genericHelper) {
        this.genericHelper = genericHelper;
    }
    public ItemIngredient getItemIngredient(ItemIngredient ii){
        if(ii.getIngredientId().equals("")&&ii.getEntryId().equals("")&&ii.getQuantity()==0) return null;
        return ItemIngredient.builder()
                .id(this.genericHelper.getId(ItemIngredientFactory.class))
                .quantity(ii.getQuantity())
                .ingredientId(ii.getIngredientId())
                .entryId(ii.getEntryId())
                .description(ii.getDescription())
                .build();
    }
}
