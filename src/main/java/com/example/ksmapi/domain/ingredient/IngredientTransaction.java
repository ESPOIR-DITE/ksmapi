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
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@IdClass(IngredientTransaction.IngredientEntryId.class)
public class IngredientTransaction {
    @Id
    private String transactionId;
    private String ingredientId;
    private int quantity;
    private double price;
    private String brand;
    private LocalDate date;
    private LocalDate expirationDate;

//    public int getPriceUnit(){
//        int priceInt = (int) price;
//        return priceInt/quantity;
//    }
    protected static class IngredientEntryId implements Serializable{
        private String transactionId, ingredientId;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof IngredientEntryId)) return false;
            IngredientEntryId that = (IngredientEntryId) o;
            return transactionId.equals(that.transactionId) && ingredientId.equals(that.ingredientId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(transactionId, ingredientId);
        }
    }
}
