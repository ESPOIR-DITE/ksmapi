package com.example.ksmapi.repository.sell;

import com.example.ksmapi.domain.sell.Period;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeriodRepository extends JpaRepository<Period,String> {
}
