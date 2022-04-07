package com.example.ksmapi.repository.sell;

import com.example.ksmapi.domain.sell.Period;
import com.example.ksmapi.domain.sell.PeriodTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PeriodTaskRepository extends JpaRepository<PeriodTask,String> {
    List<PeriodTask> readAllByPeriod(String period);
    PeriodTask readByTimeAndPeriod(LocalDate date, String period);
}
