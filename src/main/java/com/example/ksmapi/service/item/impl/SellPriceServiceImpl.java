package com.example.ksmapi.service.item.impl;

import com.example.ksmapi.domain.sell.SellPrice;
import com.example.ksmapi.repository.sell.SellPriceRepository;
import com.example.ksmapi.service.item.SellPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class SellPriceServiceImpl implements SellPriceService {
    private final SellPriceRepository repository;

    @Autowired
    public SellPriceServiceImpl(SellPriceRepository repository) {
        this.repository = repository;
    }

    @Override
    public SellPrice save(SellPrice sellPrice) {
        return repository.save(sellPrice);
    }

    @Override
    public SellPrice read(String id) {
        Optional<SellPrice> sellPriceOptional = repository.findById(id);
        return sellPriceOptional.orElse(null);
    }

    @Override
    public Boolean delete(String id) {
        SellPrice sellPrice = read(id);
        if(sellPrice!=null){
            repository.delete(sellPrice);
            return true;
        }
        return false;
    }

    @Override
    public List<SellPrice> readAll() {
        return repository.findAll();
    }

    @Override
    public List<SellPrice> findAllByBuyerTYpeIdAndDateOrderByPrice(String buyerTypeId, LocalDate date) {
        return repository.findAllByBuyerTypeIdAndDateOrderByPrice(buyerTypeId, date);
    }

    @Override
    public List<SellPrice> findAllByBuyerTYpeIdAndIsActive(String buyerTypeId, boolean isActive) {
        return repository.findAllByBuyerTypeIdAndIsActive(buyerTypeId, isActive);
    }

    @Override
    public List<SellPrice> findAllByItemIdAndIsActive(String itemId, boolean isActive) {
        return repository.findAllByItemIdAndIsActive(itemId, isActive);
    }

    @Override
    public List<SellPrice> findAllByItemIdAndBuyerTYpeId(String itemId, String buyerId) {
        return repository.findAllByItemIdAndBuyerTypeId(itemId, buyerId);
    }
}
