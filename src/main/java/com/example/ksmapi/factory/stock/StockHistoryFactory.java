package com.example.ksmapi.factory.stock;

import com.example.ksmapi.domain.stock.StockHistory;
import com.example.ksmapi.util.GenericHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class StockHistoryFactory {
    private GenericHelper genericHelper;

    @Autowired
    public StockHistoryFactory(GenericHelper genericHelper) {
        this.genericHelper = genericHelper;
    }
    public StockHistory getStockHistory(String ingredientId, Date date, int movingQuantity, String transactionType){
        if(ingredientId.equals("")&&movingQuantity ==0&&transactionType.equals("") )return null;
        return StockHistory.builder()
                .id(this.genericHelper.getId(StockHistoryFactory.class))
                .date(date)
                .movingQuantity(movingQuantity)
                .transactionId(transactionType)
                .ingredientId(ingredientId)
                .build();
    }
}
