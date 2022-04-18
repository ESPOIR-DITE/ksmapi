package com.example.ksmapi.domain.user;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.UniqueConstraint;
import java.util.Date;

@ToString
@Builder
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserAccount {
    @Id
    private String id;
    private String email;
    private String organizationId;
    private String roleId;
    @Column(unique = true)
    private String password;
    private Date date;
    private boolean state;
    private String description;

}
