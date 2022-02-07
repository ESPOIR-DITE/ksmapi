package com.example.ksmapi.domain.sell;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@ToString
@Builder
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Sell {
    @Id
    private String id;
    private String customerId;
    private String buyerTypeId;
    private double price;
    private String itemId;
    private int quantity;
    private Date date;
}
