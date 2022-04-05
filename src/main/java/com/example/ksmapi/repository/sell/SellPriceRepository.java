package com.example.ksmapi.repository.sell;

import com.example.ksmapi.domain.sell.SellPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SellPriceRepository extends JpaRepository<SellPrice,String> {
    List<SellPrice> findAllByBuyerTypeIdAndDateOrderByPrice(String buyerTypeId, LocalDate date);
    List<SellPrice> findAllByBuyerTypeIdAndIsActive(String buyerId,boolean isActive);
    List<SellPrice> findAllByItemIdAndIsActive(String buyerId,boolean isActive);
    List<SellPrice> findAllByItemIdAndBuyerTypeId(String itemId,String buyerId);
}
