package com.example.ksmapi.factory.sell;

import com.example.ksmapi.domain.sell.SellPrice;
import com.example.ksmapi.util.GenericHelper;
import org.springframework.stereotype.Component;


@Component
public class SellPriceFactory {
    private GenericHelper genericHelper;
    public SellPrice getSellPrice(SellPrice sp){
        if(sp.getPrice()==0.0&&sp.getBuyerTypeId().equals("")&&sp.getItemId().equals("")) return null;
        return SellPrice.builder()
                .id(genericHelper.getId(SellPriceFactory.class))
                .price(sp.getPrice())
                .buyerTypeId(sp.getBuyerTypeId())
                .date(sp.getDate())
                .isActive(sp.getIsActive())
                .itemId(sp.getItemId())
                .build();
    }

}
