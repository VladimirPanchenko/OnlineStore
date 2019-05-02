package ru.itprogram.entity.dto;

import java.util.Objects;

public class BrandDto {
    private String name;

    public BrandDto() {

    }

    public BrandDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BrandDto brandDto = (BrandDto) o;
        return Objects.equals(name, brandDto.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "BrandDto{" +
                "name='" + name + '\'' +
                '}';
    }
}
