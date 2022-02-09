package com.example.ksmapi.service.entry;

import com.example.ksmapi.domain.entry.Entry;
import com.example.ksmapi.service.ServiceInterface;

import java.time.LocalDate;
import java.util.List;

public interface EntryService extends ServiceInterface<Entry,String> {
    List<Entry> readAllByDate(LocalDate date);
    List<Entry> readAllBySupplier(String supplier);
}
