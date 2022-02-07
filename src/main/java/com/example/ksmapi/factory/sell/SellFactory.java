package com.example.ksmapi.factory.sell;

import com.example.ksmapi.domain.sell.Sell;
import com.example.ksmapi.util.GenericHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class SellFactory {
    private static GenericHelper genericHelper;

    @Autowired
    public SellFactory(GenericHelper genericHelper) {
        this.genericHelper = genericHelper;
    }

    public Sell getSell(Sell sell){
        if(sell.getDate()!=null&&sell.getBuyerTypeId().equals("")&&sell.getPrice()==0.0&&sell.getQuantity()==0&&sell.getItemId().equals("")) return null;
        return Sell.builder().id(genericHelper.getId(SellFactory.class))
                .price(sell.getPrice())
                .buyerTypeId(sell.getBuyerTypeId())
                .customerId(sell.getCustomerId())
                .date(sell.getDate())
                .itemId(sell.getItemId())
                .quantity(sell.getQuantity())
                .build();
    }

    public static Sell getSellObject(String customerId, String buyerTypeId, double price, String itemId, int quantity, Date date){
        if(date==null||buyerTypeId.equals("")||price==0.0&&quantity==0||itemId.equals("")) return null;
        return Sell.builder().id(genericHelper.getId(SellFactory.class))
                .price(price)
                .buyerTypeId(buyerTypeId)
                .customerId(customerId)
                .date(date)
                .itemId(itemId)
                .quantity(quantity)
                .build();
    }
}
