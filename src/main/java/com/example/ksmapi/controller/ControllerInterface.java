package com.example.ksmapi.controller;

import java.util.List;

public interface ControllerInterface<T,t> {
    T save(T t);
    T update(T t);
    T read(String id);
    boolean delete(String id);
    List<T> readAll();
}
