package com.example.ksmapi.api.sell;

import com.example.ksmapi.domain.ingredient.IngredientTransaction;
import com.example.ksmapi.domain.item.ItemIngredient;
import com.example.ksmapi.domain.sell.Sell;
import com.example.ksmapi.domain.stock.StockHistory;
import com.example.ksmapi.factory.ingredient.IngredientTransactionFactory;
import com.example.ksmapi.factory.stock.StockHistoryFactory;
import com.example.ksmapi.service.ingredient.impl.IngredientTransactionServiceImpl;
import com.example.ksmapi.service.item.impl.ItemIngredientServiceImpl;
import com.example.ksmapi.service.sell.impl.SellServiceImpl;
import com.example.ksmapi.service.stock.impl.StockHistoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
@Component
public class SellApi {
    private final IngredientTransactionServiceImpl ingredientTransactionService;
    private final SellServiceImpl sellService;
    private final StockHistoryServiceImpl stockHistoryService;
    private final ItemIngredientServiceImpl itemIngredientService;
    private final IngredientTransactionFactory ingredientTransactionFactory;
    private final StockHistoryFactory stockHistoryFactory;

    @Autowired
    public SellApi(IngredientTransactionServiceImpl ingredientTransactionService, SellServiceImpl sellService,
                   StockHistoryServiceImpl stockHistoryService, ItemIngredientServiceImpl itemIngredientService,
                   IngredientTransactionFactory ingredientTransactionFactory, StockHistoryFactory stockHistoryFactory) {
        this.ingredientTransactionService = ingredientTransactionService;
        this.sellService = sellService;
        this.stockHistoryService = stockHistoryService;
        this.itemIngredientService = itemIngredientService;
        this.ingredientTransactionFactory = ingredientTransactionFactory;
        this.stockHistoryFactory = stockHistoryFactory;
    }

    public Sell sell(Sell sell){
        List<ItemIngredient> itemIngredients = itemIngredientService.findAllByEntryId(sell.getItemId());
        if(itemIngredients.isEmpty()) return null;
        for (ItemIngredient itemIngredient: itemIngredients) {
            reduceIngredientQuantity(itemIngredient.getIngredientId(),sell.getQuantity());
            recordsToHistory(itemIngredient,sell.getQuantity());
        }
        return sellService.save(sell);
    }
    void recordsToHistory(ItemIngredient itemIngredient,int selQuantity){
        StockHistory stockHistory = stockHistoryFactory.getStockHistory(itemIngredient.getIngredientId(),new Date(),selQuantity,"sell"); //TODO we should get a transactionTypeId
        stockHistoryService.save(stockHistory);
    }
    //This method reduces the quantity by removing the sold quantity then update the records.
    boolean reduceIngredientQuantity(String ingredientId,int quantity){
       IngredientTransaction exist = ingredientTransactionService.readByIngredientId(ingredientId);
       if(exist==null) return false;
       if(exist.getQuantity()<quantity) return false;
       int currentQuantity = exist.getQuantity()-quantity;
       IngredientTransaction toUpdate = ingredientTransactionFactory.getIngredientEntry(exist.getId(),exist.getTransactionId(),exist.getIngredientId(),currentQuantity,exist.getPrice(),exist.getBrand(),exist.getDate(),exist.getExpirationDate());
       IngredientTransaction result = this.ingredientTransactionService.save(toUpdate);
       if(result!=null) return true;
       return false;
    }
}
