package com.example.ksmapi.repository.entry;

import com.example.ksmapi.domain.entry.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionTypeRepository extends JpaRepository<TransactionType,String> {
}
