package com.example.ksmapi.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum TransactionEnum {
    SELL("sell"),
    WAIST("waist"),
    BUY("buy");
    public final String VALUE;
}
