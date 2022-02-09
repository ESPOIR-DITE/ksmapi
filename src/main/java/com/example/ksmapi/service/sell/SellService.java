package com.example.ksmapi.service.sell;

import com.example.ksmapi.domain.sell.Sell;
import com.example.ksmapi.service.ServiceInterface;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


public interface SellService extends ServiceInterface<Sell,String> {
    List<Sell> findAllByCustomerIdOrderByDate(String customerId);
    List<Sell> findAllByItemIdAndDateAfter(String itemId, Date date);
    List<Sell> findAllByBuyerTypeIdOrderByDate(String buyerTypeId);
    List<Sell> findAllByBuyerTypeIdAndDateAfter(String buyerTypeId,Date date);
}
