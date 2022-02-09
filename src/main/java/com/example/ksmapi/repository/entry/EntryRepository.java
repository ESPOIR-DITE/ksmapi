package com.example.ksmapi.repository.entry;

import com.example.ksmapi.domain.entry.Entry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EntryRepository extends JpaRepository<Entry,String> {
    List<Entry> readAllByDate(LocalDate date);
    List<Entry> readAllBySupplier(String supplier);
}
