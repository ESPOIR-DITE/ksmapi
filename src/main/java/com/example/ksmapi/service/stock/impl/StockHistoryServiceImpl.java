package com.example.ksmapi.service.stock.impl;

import com.example.ksmapi.domain.stock.StockHistory;
import com.example.ksmapi.repository.stock.StockHistoryRep;
import com.example.ksmapi.service.stock.StockHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class StockHistoryServiceImpl implements StockHistoryService {
    private StockHistoryRep repository;

    @Autowired
    public StockHistoryServiceImpl(StockHistoryRep repository) {
        this.repository = repository;
    }

    @Override
    public StockHistory save(StockHistory stockHistory) {
        return repository.save(stockHistory);
    }

    @Override
    public StockHistory read(String id) {
        Optional<StockHistory> result = repository.findById(id);
        return result.orElse(null);
    }

    @Override
    public Boolean delete(String id) {
        StockHistory result = read(id);
        if(result!=null){
            repository.delete(result);
            return true;
        }
        return false;
    }

    @Override
    public List<StockHistory> readAll() {
        return repository.findAll(Sort.by(Sort.DEFAULT_DIRECTION,"date"));
    }

    @Override
    public List<StockHistory> findAllByIngredientId(String ingredientId) {
        return repository.findAllByIngredientId(ingredientId);
    }

    @Override
    public List<StockHistory> findAllByTransactionType(String transactionId) {
        return repository.findAllByTransactionId(transactionId);
    }

    @Override
    public List<StockHistory> findAllByTransactionTypeAndDate(String transactionTypeId, Date date) {
        return repository.findAllByTransactionIdAndDate(transactionTypeId,date);
    }
}
