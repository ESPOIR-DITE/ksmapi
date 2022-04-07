package com.example.ksmapi.domain.sell;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Date;

@ToString
@Builder
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PeriodTask {
    @Id
    private String id;
    private String period;
    private Date date;
    private LocalDate time;
    private String description;
}
