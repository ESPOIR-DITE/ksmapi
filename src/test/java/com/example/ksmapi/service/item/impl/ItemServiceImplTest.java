package com.example.ksmapi.service.item.impl;

import com.example.ksmapi.domain.item.Item;
import com.example.ksmapi.factory.item.ItemFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
class ItemServiceImplTest {
    private final ItemFactory itemFactory;
    private final ItemServiceImpl itemService;
    @Autowired
    public ItemServiceImplTest(ItemFactory itemFactory, ItemServiceImpl itemService) {
        this.itemFactory = itemFactory;
        this.itemService = itemService;
    }

    @BeforeEach
    void setUp() {
    }

    @Test
    void save() {
        Item item = itemFactory.getItem("Samsung",300,"x4");
        var result = itemService.save(item);
        System.out.println(result);
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
}