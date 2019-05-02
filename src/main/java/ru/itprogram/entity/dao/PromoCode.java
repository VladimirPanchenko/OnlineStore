package ru.itprogram.entity.dao;

import java.util.Objects;

public class PromoCode {
    private int id;
    private String code;
    private short discount;

    public PromoCode() {
    }

    public PromoCode(int id, String code, short discount) {
        this.id = id;
        this.code = code;
        this.discount = discount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        PromoCode promoCode = (PromoCode) o;
        return id == promoCode.id &&
                discount == promoCode.discount &&
                Objects.equals(code, promoCode.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, discount);
    }

    @Override
    public String toString() {
        return "PromoCode{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", discount=" + discount +
                '}';
    }
}
