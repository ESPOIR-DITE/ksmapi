package com.example.ksmapi.repository.sell;

import com.example.ksmapi.domain.sell.SellPeriod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SellPeriodRepository extends JpaRepository<SellPeriod,String> {
    List<SellPeriod> findAllByPeriodId(String periodId);
}
