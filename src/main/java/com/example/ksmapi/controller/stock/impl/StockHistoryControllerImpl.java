package com.example.ksmapi.controller.stock.impl;

import com.example.ksmapi.controller.stock.StockHistoryController;
import com.example.ksmapi.controller.util.ResponseDeal;
import com.example.ksmapi.domain.stock.StockHistory;
import com.example.ksmapi.factory.stock.StockHistoryFactory;
import com.example.ksmapi.service.stock.StockHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
@RestController
@CrossOrigin(origins="http://localhost:1338")
@RequestMapping("/ksm/stock-history/")
public class StockHistoryControllerImpl implements StockHistoryController {
    private StockHistoryService service;
    private StockHistoryFactory factory;
    private final ResponseDeal responseDeal;

    @Autowired
    public StockHistoryControllerImpl(StockHistoryService service, StockHistoryFactory factory, ResponseDeal responseDeal) {
        this.service = service;
        this.factory = factory;
        this.responseDeal = responseDeal;
    }

    @PostMapping("create")
    @Override
    public ResponseEntity<StockHistory> save(@RequestBody StockHistory stockHistory, HttpServletRequest request) {
        StockHistory stockHistory1 = factory.getStockHistory(stockHistory.getIngredientId(),stockHistory.getDate(),stockHistory.getMovingQuantity(),stockHistory.getTransactionId());
        StockHistory result =  service.save(stockHistory1);
        if(result!=null)
            return responseDeal.successful(result);
        return responseDeal.fail();
    }

    @PostMapping("upcate")
    @Override
    public ResponseEntity<StockHistory> update(@RequestBody StockHistory stockHistory, HttpServletRequest request) {
        StockHistory result = service.save(stockHistory);
        if(result!=null)
            return responseDeal.successful(result);
        return responseDeal.fail();
    }

    @GetMapping("read")
    @Override
    public ResponseEntity<StockHistory> read(@RequestParam("id") String id, HttpServletRequest request) {
        StockHistory result = service.read(id);
        if(result!=null)
            return responseDeal.successful(result);
        return responseDeal.fail();
    }

    @GetMapping("delete")
    @Override
    public ResponseEntity<Boolean> delete(@RequestParam("id") String id, HttpServletRequest request) {
        Boolean result = service.delete(id);
        if(result)
            return responseDeal.successful(result);
        return responseDeal.fail();
    }

    @GetMapping("reads")
    @Override
    public ResponseEntity<List<StockHistory>> readAll(HttpServletRequest request) {
        List<StockHistory> result = service.readAll();
        if(result!=null)
            return responseDeal.successful(result);
        return responseDeal.fail();
    }

    @GetMapping("reads-by-ingredient")
    @Override
    public ResponseEntity<List<StockHistory>> findAllByIngredientId(@RequestParam("ingredientId") String ingredientId, HttpServletRequest request) {
        List<StockHistory> result = service.findAllByIngredientId(ingredientId);
        if(result!=null)
            return responseDeal.successful(result);
        return responseDeal.fail();
    }

    @GetMapping("reads-by-trasaction-type")
    @Override
    public ResponseEntity<List<StockHistory>> findAllByTransactionType(@RequestParam("transactionId") String transactionId, HttpServletRequest request) {
        List<StockHistory> result = service.findAllByTransactionType(transactionId);
        if(result!=null)
            return responseDeal.successful(result);
        return responseDeal.fail();
    }

    @GetMapping("reads-by-transaction-type-and-date")
    @Override
    public ResponseEntity<List<StockHistory>> findAllByTransactionTypeAndDate(@RequestParam("transactionTypeId") String transactionTypeId,@RequestParam("date") Date date, HttpServletRequest request) {
        List<StockHistory> result = service.findAllByTransactionTypeAndDate(transactionTypeId, date);
        if(result!=null)
            return responseDeal.successful(result);
        return responseDeal.fail();
    }
}
