package com.example.ksmapi.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum GenericEnum {
    EMAIL("email");

    public final String VALUE;
}
