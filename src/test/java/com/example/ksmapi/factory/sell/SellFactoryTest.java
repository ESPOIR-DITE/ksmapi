package com.example.ksmapi.factory.sell;

import com.example.ksmapi.domain.sell.Sell;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
class SellFactoryTest {

    @Test
    void getSell() {
    }

    @Test
    void getSellObject() {
        Sell sel = SellFactory.getSellObject("100","0001",0.0,"0001",1,new Date());
        assertNull(sel);
    }
}