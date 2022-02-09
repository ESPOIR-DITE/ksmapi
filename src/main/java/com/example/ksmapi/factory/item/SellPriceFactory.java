package com.example.ksmapi.factory.item;

import com.example.ksmapi.domain.sell.SellPrice;
import com.example.ksmapi.util.GenericHelper;
import org.springframework.stereotype.Component;


@Component
public class SellPriceFactory {
    private GenericHelper genericHelper;
    public SellPrice getSellPrice(SellPrice sp){
        if(sp.getPrice()==0.0&&sp.getBuyerTYpeId().equals("")&&sp.getItemId().equals("")) return null;
        return SellPrice.builder()
                .id(genericHelper.getId(SellPriceFactory.class))
                .price(sp.getPrice())
                .buyerTYpeId(sp.getBuyerTYpeId())
                .date(sp.getDate())
                .isActive(sp.getIsActive())
                .itemId(sp.getItemId())
                .build();
    }

}
