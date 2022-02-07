package com.example.ksmapi.factory.item;
import com.example.ksmapi.domain.item.Item;
import com.example.ksmapi.util.GenericHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ItemFactory {
    private GenericHelper genericHelper;
    @Autowired
    public ItemFactory(GenericHelper genericHelper) {
        this.genericHelper = genericHelper;
    }

    public Item getItem(Item item){
        if(item.costPrice==0.0 && item.name.equals("")) return null;
        return Item.builder().id(genericHelper.getId(ItemFactory.class))
                .name(item.getName())
                .description(item.getDescription())
                .costPrice(item.getCostPrice()).build();
    }

}
