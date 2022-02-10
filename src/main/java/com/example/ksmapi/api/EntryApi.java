package com.example.ksmapi.api;

import com.example.ksmapi.domain.entry.Transaction;
import com.example.ksmapi.domain.entry.EntryIngredientPresentation;
import com.example.ksmapi.domain.ingredient.IngredientTransaction;
import com.example.ksmapi.factory.ingredient.IngredientEntryFactory;
import com.example.ksmapi.service.entry.impl.TransactionServiceImpl;
import com.example.ksmapi.service.ingredient.impl.IngredientEntryServiceImpl;
import com.example.ksmapi.service.ingredient.impl.IngredientServiceImpl;
import org.springframework.stereotype.Component;

@Component
public class EntryApi {
    private final TransactionServiceImpl entryService;
    private final IngredientEntryServiceImpl ingredientEntryService;
    private final IngredientServiceImpl ingredientService;
    private final IngredientEntryFactory ingredientEntryFactory;

    public EntryApi(TransactionServiceImpl entryService, IngredientEntryServiceImpl ingredientEntryService,
                    IngredientServiceImpl ingredientService,IngredientEntryFactory ingredientEntryFactory) {
        this.entryService = entryService;
        this.ingredientEntryService = ingredientEntryService;
        this.ingredientService = ingredientService;
        this.ingredientEntryFactory = ingredientEntryFactory;
    }

    public boolean recordNewEntry(EntryIngredientPresentation presentation){
        String entryId =createEntry(presentation.getEntry());
        if(!entryId.equals("")){
            return createIngredientEntries(presentation,entryId);
        }
        return false;
    }
    String createEntry(Transaction entry){
        Transaction entry1 = this.entryService.save(entry);
        if(entry1 !=null) return entry1.getId();
        return null;
    }
    boolean createIngredientEntries(EntryIngredientPresentation presentation,String entryId){
         boolean result = false;
        try {
            for (EntryIngredientPresentation.StockIngredient ingredient : presentation.getIngredientEntry()) {
                    IngredientTransaction ingredientTransaction = ingredientEntryFactory.getIngredientEntry(
                            entryId,
                            ingredient.getIngredient().getId()
                            , ingredient.getIngredientTransaction().getQuantity()
                            , ingredient.getIngredientTransaction().getPrice()
                            , ingredient.getIngredientTransaction().getBrand()
                            , ingredient.getIngredientTransaction().getDate()
                            , ingredient.getIngredientTransaction().getExpirationDate()
                    );
                    ingredientEntryService.save(ingredientTransaction);
            }
            return true;
        }catch (NullPointerException nullPointerException){
            return result;
        }


    }
}
