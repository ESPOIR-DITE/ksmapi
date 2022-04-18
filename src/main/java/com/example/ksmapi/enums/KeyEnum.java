package com.example.ksmapi.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum KeyEnum {
    PUBLIC_KEY("Public Key");

    public final String VALUE;
}
