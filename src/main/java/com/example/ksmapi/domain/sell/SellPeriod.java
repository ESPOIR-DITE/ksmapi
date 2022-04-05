package com.example.ksmapi.domain.sell;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@ToString
@Builder
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class SellPeriod {
    @Id
    private String id;
    private String periodId;
    private String sellId;
    private double amount;
    private String description;
}
