package ru.itprogram.service.converter;

public interface Converter<T, V> {
    T conversion(V v);
}
