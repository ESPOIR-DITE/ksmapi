package com.example.ksmapi.repository.item;

import com.example.ksmapi.domain.item.SellPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SellPriceRepository extends JpaRepository<SellPrice,String> {
    List<SellPrice> findAllByBuyerTYpeIdAndDateOrderByPrice(String buyerTypeId, LocalDate date);
    List<SellPrice> findAllByBuyerTYpeIdAndIsActive(String buyerId,boolean isActive);
    List<SellPrice> findAllByItemIdAndIsActive(String buyerId,boolean isActive);
    List<SellPrice> findAllByItemIdAndBuyerTYpeId(String itemId,String buyerId);
}
