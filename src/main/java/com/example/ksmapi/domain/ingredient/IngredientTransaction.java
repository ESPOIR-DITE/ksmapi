package com.example.ksmapi.domain.ingredient;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Builder
@Getter
@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class IngredientTransaction {
    @Id
    private String id;
    private String transactionId;
    private String ingredientId;
    private int quantity;
    private double price;
    private String brand;
    private LocalDate date;
    private LocalDate expirationDate;
}
