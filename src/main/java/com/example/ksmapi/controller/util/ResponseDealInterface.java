package com.example.ksmapi.controller.util;

import org.springframework.http.ResponseEntity;

public interface ResponseDealInterface<T,t> {
    ResponseEntity<T> successful(T t);
    ResponseEntity<T> fail();
    ResponseEntity<T> notAllowed();
}
