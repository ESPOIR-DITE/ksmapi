package com.example.ksmapi.repository.item;

import com.example.ksmapi.domain.item.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item,String> {
    List<Item> findByOrderByCostPriceAsc();
}
