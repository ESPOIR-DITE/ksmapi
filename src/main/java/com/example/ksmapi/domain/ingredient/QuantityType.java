package com.example.ksmapi.domain.ingredient;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class QuantityType {
    @Id
    private String id;
    private String name;
    private String description;

}
