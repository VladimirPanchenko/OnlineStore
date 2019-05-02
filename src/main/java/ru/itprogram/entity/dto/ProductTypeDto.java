package ru.itprogram.entity.dto;

import java.util.Objects;

public class ProductTypeDto {
    private String type;

    public ProductTypeDto() {

    }

    public ProductTypeDto(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductTypeDto that = (ProductTypeDto) o;
        return Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }

    @Override
    public String toString() {
        return "ProductTypeDto{" +
                "type='" + type + '\'' +
                '}';
    }
}
