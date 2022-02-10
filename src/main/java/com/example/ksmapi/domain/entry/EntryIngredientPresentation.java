package com.example.ksmapi.domain.entry;

import com.example.ksmapi.domain.ingredient.Ingredient;
import com.example.ksmapi.domain.ingredient.IngredientTransaction;
import lombok.*;

import java.util.List;

@Builder
@Getter
@ToString
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class EntryIngredientPresentation {
    private Transaction entry;
    private List<StockIngredient> ingredientEntry;
    @Builder
    @Getter
    @ToString
    @AllArgsConstructor(access = AccessLevel.PUBLIC)
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class StockIngredient{
        Ingredient ingredient;
        IngredientTransaction ingredientTransaction;
    }
}
