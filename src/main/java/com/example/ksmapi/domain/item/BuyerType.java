package com.example.ksmapi.domain.item;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@ToString
@Builder
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class BuyerType {
    @Id
    private String Id;
    private String name;
}
