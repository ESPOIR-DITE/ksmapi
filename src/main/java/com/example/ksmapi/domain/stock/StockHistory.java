package com.example.ksmapi.domain.stock;

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
public class StockHistory {
    @Id
    private String id;
    private String ingredientId;
    private Date date;
    private int movingQuantity;
    private String transactionId;

}
