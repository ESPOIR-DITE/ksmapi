package com.example.ksmapi.factory.ingredient;

import com.example.ksmapi.domain.ingredient.Ingredient;
import com.example.ksmapi.domain.ingredient.IngredientEntry;
import com.example.ksmapi.util.GenericHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IngredientEntryFactory {
    private GenericHelper genericHelper;
    @Autowired
    public IngredientEntryFactory(GenericHelper genericHelper) {
        this.genericHelper = genericHelper;
    }

    public IngredientEntry getIngredientEntry(IngredientEntry ie){
        if(ie.getIngredientId().equals("")&&ie.getEntryId().equals("")&&ie.getPrice()==0.0&&ie.getQuantity()==0) return null;
        return IngredientEntry.builder()
                .entryId(ie.getEntryId())
                .ingredientId(ie.getIngredientId())
                .brand(ie.getBrand())
                .price(ie.getPrice())
                .quantity(ie.getQuantity())
                .build();
    }
}
