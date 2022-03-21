package com.example.ksmapi.controller.stock;

import com.example.ksmapi.controller.ControllerInterface;
import com.example.ksmapi.domain.stock.StockHistory;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

public interface StockHistoryController extends ControllerInterface<StockHistory,String> {
    ResponseEntity<List<StockHistory>> findAllByIngredientId(String ingredientId, HttpServletRequest request);
    ResponseEntity<List<StockHistory>> findAllByTransactionType(String transactionId, HttpServletRequest request);
    ResponseEntity<List<StockHistory>> findAllByTransactionTypeAndDate(String transactionTypeId, Date date, HttpServletRequest request);
}
