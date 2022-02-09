package com.example.ksmapi.repository.sell;

import com.example.ksmapi.domain.sell.Sell;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface SellRepository extends JpaRepository<Sell,String> {
    List<Sell> findAllByCustomerIdOrderByDate(String customerId);
    List<Sell> findAllByItemIdAndDateAfter(String itemId, Date date);
    List<Sell> findAllByBuyerTypeIdOrderByDate(String buyerTypeId);
    List<Sell> findAllByBuyerTypeIdAndDateAfter(String buyerTypeId,Date date);
}
