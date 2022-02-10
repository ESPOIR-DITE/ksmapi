package com.example.ksmapi.repository.entry;

import com.example.ksmapi.domain.entry.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,String> {
    List<Transaction> readAllByDate(LocalDate date);
    List<Transaction> readAllBySupplier(String supplier);
    List<Transaction> readAllByTransactionTypeId(String transactionId);
}
