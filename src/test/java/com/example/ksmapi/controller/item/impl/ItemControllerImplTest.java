package com.example.ksmapi.controller.item.impl;

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
class ItemControllerImplTest {
    private Item item = null;
    private ItemFactory itemFactory;
    private ItemControllerImpl itemController;

    @Autowired
    public ItemControllerImplTest(ItemFactory itemFactory, ItemControllerImpl itemController) {
        this.itemFactory = itemFactory;
        this.itemController = itemController;
    }

    @BeforeEach
    void setUp() {
    }

    @Test
    void save() {
        item = itemFactory.getItem("Iphone",200,"S6");
        var result = itemController.save(item);
        System.out.println(result.toString());
    }

    @Test
    void update() {
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