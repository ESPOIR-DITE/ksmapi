package com.example.ksmapi.service.item;

import com.example.ksmapi.domain.item.Item;
import com.example.ksmapi.service.ServiceInterface;
import org.hibernate.service.spi.ServiceInitiator;

public interface ItemService extends ServiceInterface<Item,String> {

}
