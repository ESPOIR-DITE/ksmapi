package com.example.ksmapi.repository.stock;

import com.example.ksmapi.domain.stock.StockHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface StockHistoryRep extends JpaRepository<StockHistory,String> {
    List<StockHistory> findAllByIngredientId(String ingredientId);
    List<StockHistory> findAllByTransactionType(String transactionId);
    List<StockHistory> findAllByTransactionTypeAndDate(String transactionTypeId, Date date);
}
