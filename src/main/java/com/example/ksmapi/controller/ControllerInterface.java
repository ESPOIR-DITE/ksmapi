package com.example.ksmapi.controller;

import org.springframework.http.ResponseEntity;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

public interface ControllerInterface<T,t> {
    ResponseEntity<T> save(T t, HttpServletRequest request);
    ResponseEntity<T> update(T t, HttpServletRequest request);
    ResponseEntity<T> read(String id, HttpServletRequest request);
    ResponseEntity<Boolean> delete(String id, HttpServletRequest request);
    ResponseEntity<List<T>> readAll(HttpServletRequest request);

}
