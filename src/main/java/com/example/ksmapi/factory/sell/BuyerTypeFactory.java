package com.example.ksmapi.factory.sell;

import com.example.ksmapi.domain.sell.BuyerType;
import com.example.ksmapi.util.GenericHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BuyerTypeFactory {
    private GenericHelper genericHelper;

    @Autowired
    public BuyerTypeFactory(GenericHelper genericHelper) {
        this.genericHelper = genericHelper;
    }

    public BuyerType getBuyer(BuyerType buyerType){
        if(buyerType.getName().equals("")) return null;
        return BuyerType.builder()
                .id(genericHelper.getId(BuyerTypeFactory.class))
                .name(buyerType.getName())
                .build();
    }
}
