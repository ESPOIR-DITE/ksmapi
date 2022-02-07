package com.example.ksmapi.util;

import com.example.ksmapi.domain.item.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.junit.jupiter.api.Assertions.*;

class StringHelperTest {



    Item item = new Item("jdjdj","Bonzer",45.00,"voila");
    @Test
    void isEmpty() throws IllegalAccessException {
        System.out.println(StringHelper.isEmpty(item,0));
    }
}