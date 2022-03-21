package com.example.ksmapi.service.stock;

import com.example.ksmapi.domain.stock.StockHistory;
import com.example.ksmapi.service.ServiceInterface;

import java.util.Date;
import java.util.List;

public interface StockHistoryService extends ServiceInterface<StockHistory,String> {
    List<StockHistory> findAllByIngredientId(String ingredientId);
    List<StockHistory> findAllByTransactionType(String transactionId);
    List<StockHistory> findAllByTransactionTypeAndDate(String transactionTypeId, Date date);
}
