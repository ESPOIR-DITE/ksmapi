package com.example.ksmapi.domain.user;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@ToString
@Builder
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Users {
    @Id
    private String email;
    private String firstName;
    private String middleName;
    private String lastName;
}
