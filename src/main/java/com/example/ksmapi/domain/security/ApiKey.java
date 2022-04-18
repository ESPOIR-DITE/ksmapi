package com.example.ksmapi.domain.security;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@ToString
@Getter
@Builder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ApiKey {
    @Id
     private String keyType;
     private String value;
     private boolean active;
     private LocalDateTime dateCreated;
}
