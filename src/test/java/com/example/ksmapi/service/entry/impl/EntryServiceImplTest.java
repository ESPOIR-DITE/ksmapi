package com.example.ksmapi.service.entry.impl;

import com.example.ksmapi.domain.entry.Entry;
import com.example.ksmapi.factory.EntryFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
class EntryServiceImplTest {
    private EntryServiceImpl entryService;
    private EntryFactory entryFactory;
    @Autowired
    public EntryServiceImplTest(EntryServiceImpl entryService, EntryFactory entryFactory) {
        this.entryService = entryService;
        this.entryFactory = entryFactory;
    }

    @BeforeEach
    void setUp() {

    }

    @Test
    void save() {
        Entry entry = entryService.save(entryFactory.getEntryObject(LocalDate.of(2021,06,20),4.30,"kaldit"));
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