package com.example.ksmapi.service.item;

import com.example.ksmapi.domain.sell.SellPrice;
import com.example.ksmapi.service.ServiceInterface;

import java.time.LocalDate;
import java.util.List;

public interface SellPriceService extends ServiceInterface<SellPrice,String> {
    List<SellPrice> findAllByBuyerTYpeIdAndDateOrderByPrice(String buyerTypeId, LocalDate date);
    List<SellPrice> findAllByBuyerTYpeIdAndIsActive(String buyerId,boolean isActive);
    List<SellPrice> findAllByItemIdAndIsActive(String buyerId,boolean isActive);
    List<SellPrice> findAllByItemIdAndBuyerTYpeId(String itemId,String buyerId);
}
