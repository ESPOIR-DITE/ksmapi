package com.example.ksmapi.domain.organisation;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@ToString
@Builder
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Organisation {
    @Id
    private String id;
    private String name;
    private String organisationId;
}
