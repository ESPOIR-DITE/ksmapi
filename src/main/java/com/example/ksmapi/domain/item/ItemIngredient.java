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
public class ItemIngredient {
    @Id
    private String id;
    private String entryId;
    private String ingredientId;
    private int quantity;
    private String description;
}
