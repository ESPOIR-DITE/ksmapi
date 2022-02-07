package com.example.ksmapi.factory;

import com.example.ksmapi.domain.ingredient.Ingredient;
import com.example.ksmapi.util.GenericHelper;
import com.example.ksmapi.util.StringHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public class IngredientFactory {
   private GenericHelper genericHelper;

   @Autowired
   public IngredientFactory(GenericHelper genericHelper) {
      this.genericHelper = genericHelper;
   }

    public Ingredient getIngredient(Ingredient ingredient){
        if(ingredient.getName().equals("")&&ingredient.getQuantityType().equals("")) return null;
        return Ingredient.builder()
                .id(genericHelper.getId(IngredientFactory.class))
                .brand(ingredient.getBrand())
                .description(ingredient.getDescription())
                .name(ingredient.getName())
                .quantityType(ingredient.getQuantityType())
                .build();
    }
}
