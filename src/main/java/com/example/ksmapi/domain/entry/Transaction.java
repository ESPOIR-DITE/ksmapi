package com.example.ksmapi.domain.entry;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Builder
@Getter
@ToString
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Transaction {
    @Id
    private String id;
    private double amount;
    private LocalDate date;
    private String supplier;
    private String transactionTypeId;
}
