package com.example.ksmapi.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum SecurityEnum {
    ISSUER("espoirditekemena.com"), SITE_ACCESS("Site Access"),
    SITE_USERS("Site Users"), AUTHORITIES("Authorities"),
    PUBLIC_PHRASE(ISSUER.VALUE);

    public final String VALUE;
}
