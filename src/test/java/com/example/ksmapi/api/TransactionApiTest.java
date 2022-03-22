package com.example.ksmapi.api;

import com.example.ksmapi.domain.entry.Transaction;
import com.example.ksmapi.domain.entry.EntryIngredientPresentation;
import com.example.ksmapi.domain.ingredient.Ingredient;
import com.example.ksmapi.domain.ingredient.IngredientTransaction;
import com.example.ksmapi.factory.entry.TransactionFactory;
import com.example.ksmapi.factory.ingredient.IngredientFactory;
import com.example.ksmapi.factory.ingredient.IngredientTransactionFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
class TransactionApiTest {
    private final TransactionApi transactionApi;
    private TransactionFactory transactionFactory;
    private Transaction entry;
    private IngredientTransaction ingredientTransaction;
    private EntryIngredientPresentation.StockIngredient stockIngredient;
    private IngredientFactory ingredientFactory;
    private IngredientTransactionFactory ingredientTransactionFactory;

    @Autowired
    public TransactionApiTest(TransactionApi transactionApi, TransactionFactory transactionFactory,
                              IngredientFactory ingredientFactory, IngredientTransactionFactory ingredientTransactionFactory) {
        this.transactionApi = transactionApi;
        this.transactionFactory = transactionFactory;
        this.ingredientFactory = ingredientFactory;
        this.ingredientTransactionFactory = ingredientTransactionFactory;
    }

    @BeforeEach
    void setUp() {
        ingredientTransaction = ingredientTransactionFactory.getIngredientEntry("","","",20,400,"bravo",LocalDate.now(),LocalDate.of(2022,06,20));
        Ingredient ingredient = ingredientFactory.getIngredientObject("chicken","iueei","984083","julia",39);
        entry = transactionFactory.getEntryObject(LocalDate.now(),3000,"espoir");
        stockIngredient = new EntryIngredientPresentation.StockIngredient(ingredient, ingredientTransaction);

    }

    @Test
    void recordNewEntry() {
        ArrayList<EntryIngredientPresentation.StockIngredient> stockIngredients = new ArrayList<>();
        stockIngredients.add(stockIngredient);
        EntryIngredientPresentation eip = new EntryIngredientPresentation(entry,stockIngredients);
        Boolean result = transactionApi.recordNewEntry(eip);
        assertTrue(result);
    }

    @Test
    void createEntry() {
//        Entry entry = EntryFactory.
//        entryApi.createEntry()
    }

    @Test
    void createIngredientEntries() {
    }
}