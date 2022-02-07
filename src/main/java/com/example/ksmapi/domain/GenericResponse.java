package com.example.ksmapi.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class GenericResponse {
    private final boolean success;
    private final String description;
    private final Object payload;
}
