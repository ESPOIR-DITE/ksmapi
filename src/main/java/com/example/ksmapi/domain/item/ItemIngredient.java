package com.example.ksmapi.domain.item;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@IdClass(ItemIngredient.ItemIngredientId.class)
public class ItemIngredient {
    @Id
    private String entryId;
    private String ingredientId;
    private int quantity;
    private String description;
    protected static class ItemIngredientId implements Serializable{
        private String entryId, ingredientId;

        @Override
        public int hashCode() {
            return Objects.hash(entryId, ingredientId);
        }

        public boolean equals(Object o){
            if(this == o) return true;
            if(o == null || getClass() != o.getClass()) return false;
            ItemIngredientId that =(ItemIngredientId) o;
            return entryId.equals(that.entryId) && ingredientId.equals(that.ingredientId);
        }
    }
}
