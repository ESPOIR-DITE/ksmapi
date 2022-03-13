package com.example.ksmapi.factory.ingredient;

import com.example.ksmapi.domain.ingredient.Ingredient;
import com.example.ksmapi.util.GenericHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IngredientFactory {
   private GenericHelper genericHelper;

   @Autowired
   public IngredientFactory(GenericHelper genericHelper) {
      this.genericHelper = genericHelper;
   }

    public Ingredient getIngredient(Ingredient ingredient){
        if(ingredient.getName().equals("")&&ingredient.getQuantityType().equals("")&&ingredient.getPrice()!=0) return null;
        return Ingredient.builder()
                .id(genericHelper.getId(IngredientFactory.class))
                .brand(ingredient.getBrand())
                .description(ingredient.getDescription())
                .name(ingredient.getName())
                .price(ingredient.getPrice())
                .quantityType(ingredient.getQuantityType())
                .build();
    }
    public Ingredient getIngredientObject(String name ,String description, String quantityType, String brand,double price){
        if(name.equals("")&&quantityType.equals("")&&price!=0) return null;
        return Ingredient.builder()
                .id(genericHelper.getId(IngredientFactory.class))
                .brand(brand)
                .price(price)
                .description(description)
                .name(name)
                .quantityType(quantityType)
                .build();
    }
}
