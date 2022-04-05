package com.example.ksmapi.repository.sell;

import com.example.ksmapi.domain.sell.BuyerType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyerTypeRepository extends JpaRepository<BuyerType, String> {
}
