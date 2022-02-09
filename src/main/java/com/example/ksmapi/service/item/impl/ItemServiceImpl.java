package com.example.ksmapi.service.item.impl;

import com.example.ksmapi.domain.item.Item;
import com.example.ksmapi.repository.item.ItemRepository;
import com.example.ksmapi.service.item.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Item save(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public Item read(String id) {
        Optional<Item> itemOptional = itemRepository.findById(id);
        return itemOptional.orElse(null);
    }

    @Override
    public Boolean delete(String id) {
        Item item = read(id);
        if(item!=null){
            itemRepository.delete(item);
            return true;
        }
        return false;
    }

    @Override
    public List<Item> readAll() {
        return itemRepository.findByOrderByCostPriceAsc();
    }
}
