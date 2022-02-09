package com.example.ksmapi.service.sell.impl;

import com.example.ksmapi.domain.sell.Sell;
import com.example.ksmapi.repository.sell.SellRepository;
import com.example.ksmapi.service.sell.SellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service
public class SellServiceImpl implements SellService {
    private final SellRepository sellRepository;

    @Autowired
    public SellServiceImpl(SellRepository sellRepository) {
        this.sellRepository = sellRepository;
    }


    @Override
    public Sell save(Sell sell) {
        return sellRepository.save(sell);
    }

    @Override
    public Sell read(String id) {
        Optional<Sell> sellOptional = sellRepository.findById(id);
        return sellOptional.orElse(null);
    }

    @Override
    public Boolean delete(String id) {
        Sell sell = read(id);
        if(sell!= null){
            sellRepository.delete(sell);
            return true;
        }
        return false;
    }

    @Override
    public List<Sell> readAll() {
        return sellRepository.findAll();
    }

    @Override
    public List<Sell> findAllByCustomerIdOrderByDate(String customerId) {
        return sellRepository.findAllByCustomerIdOrderByDate(customerId);
    }

    @Override
    public List<Sell> findAllByItemIdAndDateAfter(String itemId, Date date) {
        return sellRepository.findAllByItemIdAndDateAfter(itemId, date);
    }

    @Override
    public List<Sell> findAllByBuyerTypeIdOrderByDate(String buyerTypeId) {
        return sellRepository.findAllByBuyerTypeIdOrderByDate(buyerTypeId);
    }

    @Override
    public List<Sell> findAllByBuyerTypeIdAndDateAfter(String buyerTypeId, Date date) {
        return sellRepository.findAllByBuyerTypeIdAndDateAfter(buyerTypeId, date);
    }
}
