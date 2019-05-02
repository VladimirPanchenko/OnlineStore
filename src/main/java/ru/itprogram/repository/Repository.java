package ru.itprogram.repository;

import java.util.List;

public interface Repository<T> {
    List<T> getAllEntity();
    void saveEntity(T t);
}
