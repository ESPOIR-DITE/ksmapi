package com.example.ksmapi.factory.ingredient;

import com.example.ksmapi.domain.ingredient.IngredientTransaction;
import com.example.ksmapi.util.GenericHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class IngredientTransactionFactory {
    private GenericHelper genericHelper;
    @Autowired
    public IngredientTransactionFactory(GenericHelper genericHelper) {
        this.genericHelper = genericHelper;
    }

    public IngredientTransaction getIngredientEntryObject(IngredientTransaction ie){
        if(ie.getIngredientId().equals("")&&ie.getTransactionId().equals("")&&ie.getPrice()==0.0&&ie.getQuantity()==0) return null;
        return IngredientTransaction.builder()
                .transactionId(ie.getTransactionId())
                .ingredientId(ie.getIngredientId())
                .brand(ie.getBrand())
                .price(ie.getPrice())
                .quantity(ie.getQuantity())
                .date(ie.getDate())
                .expirationDate(ie.getExpirationDate())
                .build();
    }
    public IngredientTransaction getIngredientEntry(String entryId, String ingredientId, int quantity, double price, String brand, LocalDate date, LocalDate expirationDate){
        if(ingredientId.equals("")&&entryId.equals("")&&price==0.0&&quantity==0) return null;
        return IngredientTransaction.builder()
                .transactionId(entryId)
                .ingredientId(ingredientId)
                .brand(brand)
                .price(price)
                .quantity(quantity)
                .expirationDate(expirationDate)
                .date(date)
                .build();
    }
}
