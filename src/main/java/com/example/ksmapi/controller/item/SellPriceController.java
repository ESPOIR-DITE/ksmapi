package com.example.ksmapi.controller.item;

import com.example.ksmapi.controller.ControllerInterface;
import com.example.ksmapi.domain.sell.SellPrice;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.List;

public interface SellPriceController extends ControllerInterface<SellPrice,String> {
    ResponseEntity<List<SellPrice>> findAllByBuyerTYpeIdAndDateOrderByPrice(String buyerTypeId, LocalDate date, HttpServletRequest request);
    ResponseEntity<List<SellPrice>> findAllByBuyerTYpeIdAndIsActive(String buyerId,boolean isActive,HttpServletRequest request);
    ResponseEntity<List<SellPrice>> findAllByItemIdAndIsActive(String buyerId,boolean isActive, HttpServletRequest request);
    ResponseEntity<List<SellPrice>> findAllByItemIdAndBuyerTYpeId(String itemId,String buyerId, HttpServletRequest request);
}
