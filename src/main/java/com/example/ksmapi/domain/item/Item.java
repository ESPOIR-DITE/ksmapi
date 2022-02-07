package com.example.ksmapi.domain.item;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Item {
    @Id
    public String id;
    public String name;
    public double costPrice;
    public String description;
}
