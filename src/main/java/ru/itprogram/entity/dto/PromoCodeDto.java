package ru.itprogram.entity.dto;

import java.util.Objects;

public class PromoCodeDto {
    private String code;
    private short discount;

    public PromoCodeDto() {

    }

    public PromoCodeDto(String code, short discount) {
        this.code = code;
        this.discount = discount;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public short getDiscount() {
        return discount;
    }

    public void setDiscount(short discount) {
        this.discount = discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PromoCodeDto that = (PromoCodeDto) o;
        return discount == that.discount &&
                Objects.equals(code, that.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, discount);
    }

    @Override
    public String toString() {
        return "PromoCodeDto{" +
                "code='" + code + '\'' +
                ", discount=" + discount +
                '}';
    }
}
