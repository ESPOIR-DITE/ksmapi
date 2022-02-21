package com.example.ksmapi.controller.sell;

import com.example.ksmapi.controller.ControllerInterface;
import com.example.ksmapi.domain.sell.Sell;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

public interface SellController extends ControllerInterface<Sell, String> {
    ResponseEntity<List<Sell>> findAllByCustomerIdOrderByDate(String customerId, HttpServletRequest request);
    ResponseEntity<List<Sell>> findAllByItemIdAndDateAfter(String itemId, Date date, HttpServletRequest request);
    ResponseEntity<List<Sell>> findAllByBuyerTypeIdOrderByDate(String buyerTypeId, HttpServletRequest request);
    ResponseEntity<List<Sell>> findAllByBuyerTypeIdAndDateAfter(String buyerTypeId,Date date, HttpServletRequest request);
}
