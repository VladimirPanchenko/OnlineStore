package ru.itprogram.service;

import java.util.List;

public interface Service<T> {
    List<T> getAll();
    void add(T t);
}
