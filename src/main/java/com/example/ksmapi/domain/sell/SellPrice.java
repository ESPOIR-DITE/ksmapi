package com.example.ksmapi.domain.sell;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@ToString
@Builder
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class SellPrice {
    @Id
    private String id;
    private String itemId;
    private String buyerTYpeId;
    private double price;
    private LocalDate date;
    private Boolean isActive;

}
