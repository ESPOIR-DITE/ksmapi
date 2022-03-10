package com.example.ksmapi.factory.ingredient;

import com.example.ksmapi.domain.ingredient.Ingredient;
import com.example.ksmapi.domain.ingredient.QuantityType;
import com.example.ksmapi.util.GenericHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QuantityTypeFactory {
   private GenericHelper genericHelper;

   @Autowired
   public QuantityTypeFactory(GenericHelper genericHelper) {
      this.genericHelper = genericHelper;
   }

    public QuantityType getQuantityType(QuantityType ingredient){
        if(ingredient.getName().equals("")) return null;
        return QuantityType.builder()
                .id(genericHelper.getId(QuantityTypeFactory.class))
                .description(ingredient.getDescription())
                .name(ingredient.getName())
                .build();
    }
    public QuantityType getQuantityTypeObject(String name ,String description){
        if(name.equals("")) return null;
        return QuantityType.builder()
                .id(genericHelper.getId(QuantityTypeFactory.class))
                .description(description)
                .name(name)
                .build();
    }
}
