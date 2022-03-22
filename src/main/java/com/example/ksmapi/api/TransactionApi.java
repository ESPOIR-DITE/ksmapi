package com.example.ksmapi.api;

import com.example.ksmapi.domain.entry.Transaction;
import com.example.ksmapi.domain.entry.EntryIngredientPresentation;
import com.example.ksmapi.domain.ingredient.IngredientTransaction;
import com.example.ksmapi.factory.ingredient.IngredientTransactionFactory;
import com.example.ksmapi.service.entry.impl.TransactionServiceImpl;
import com.example.ksmapi.service.ingredient.impl.IngredientTransactionServiceImpl;
import com.example.ksmapi.service.ingredient.impl.IngredientServiceImpl;
import org.springframework.stereotype.Component;

@Component
public class TransactionApi {
    private final TransactionServiceImpl entryService;
    private final IngredientTransactionServiceImpl ingredientEntryService;
    private final IngredientServiceImpl ingredientService;
    private final IngredientTransactionFactory ingredientTransactionFactory;

    public TransactionApi(TransactionServiceImpl entryService, IngredientTransactionServiceImpl ingredientEntryService,
                          IngredientServiceImpl ingredientService, IngredientTransactionFactory ingredientTransactionFactory) {
        this.entryService = entryService;
        this.ingredientEntryService = ingredientEntryService;
        this.ingredientService = ingredientService;
        this.ingredientTransactionFactory = ingredientTransactionFactory;
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
                    IngredientTransaction ingredientTransaction = ingredientTransactionFactory.getIngredientEntry(

                            ingredient.getIngredientTransaction().getId()
                            , entryId
                            , ingredient.getIngredient().getId()
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
