package com.example.ksmapi.domain.sell;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@ToString
@Builder
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Period {
    @Id
    private String id;
    private String period;
    private String description;
}
