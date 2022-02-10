package com.example.ksmapi.service.entry.impl;

import com.example.ksmapi.domain.entry.Transaction;
import com.example.ksmapi.factory.entry.TransactionFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
class TransactionServiceImplTest {
    private TransactionServiceImpl entryService;
    private TransactionFactory transactionFactory;
    @Autowired
    public TransactionServiceImplTest(TransactionServiceImpl entryService, TransactionFactory transactionFactory) {
        this.entryService = entryService;
        this.transactionFactory = transactionFactory;
    }

    @BeforeEach
    void setUp() {

    }

    @Test
    void save() {
        Transaction entry = entryService.save(transactionFactory.getEntryObject(LocalDate.of(2021,06,20),4.30,"kaldit"));
        assertNotNull(entry);
    }

    @Test
    void read() {
    }

    @Test
    void delete() {
    }

    @Test
    void readAll() {
    }

    @Test
    void readAllByDate() {
        System.out.println(this.entryService.readAllByDate(LocalDate.of(2021,06,20)));
    }

    @Test
    void readAllBySupplier() {
        System.out.println(this.entryService.readAllBySupplier("kaldit"));
    }
}