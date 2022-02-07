package com.example.ksmapi.repository.item;

import com.example.ksmapi.domain.item.BuyerType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyerTypeRepository extends JpaRepository<BuyerType, String> {
}
