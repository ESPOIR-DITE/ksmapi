package com.example.ksmapi.domain.ingredient;

import com.sun.istack.NotNull;
import lombok.*;
import org.springframework.lang.NonNull;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class IngredientEntry {
    @NotNull
    @Id
    private String entryId;
    private String ingredientId;
    private int quantity;
    private double price;
    private String brand;

    public int getPriceUnit(){
        int priceInt = (int) price;
        return priceInt/quantity;
    }
    protected static class IngredientEntryId implements Serializable{
        private String entryId, ingredientId;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof IngredientEntryId)) return false;
            IngredientEntryId that = (IngredientEntryId) o;
            return entryId.equals(that.entryId) && ingredientId.equals(that.ingredientId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(entryId, ingredientId);
        }
    }
}
