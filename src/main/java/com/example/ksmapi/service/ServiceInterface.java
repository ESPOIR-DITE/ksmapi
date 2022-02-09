package com.example.ksmapi.service;

import java.util.List;

public interface ServiceInterface <T, t>{
    T save(T t);
    T read(String id);
    Boolean delete(String id);
    List<T> readAll();
}
