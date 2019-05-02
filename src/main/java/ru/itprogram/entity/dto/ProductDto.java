package ru.itprogram.entity.dto;

import java.util.Objects;

public class ProductDto {
    private int id;
    private BrandDto brandDto;
    private ProductTypeDto productTypeDto;
    private String description;
    private int quantity;
    private short warranty;
    private boolean available;
    private double price;
    private PromoCodeDto promoCodeDto;

    public ProductDto() {

    }

    public ProductDto(int id, BrandDto brandDto, ProductTypeDto productTypeDto, String description,
                      int quantity, short warranty, boolean available, double price,
                      PromoCodeDto promoCodeDto) {
        this.id = id;
        this.brandDto = brandDto;
        this.productTypeDto = productTypeDto;
        this.description = description;
        this.quantity = quantity;
        this.warranty = warranty;
        this.available = available;
        this.price = price;
        this.promoCodeDto = promoCodeDto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BrandDto getBrandDto() {
        return brandDto;
    }

    public void setBrandDto(BrandDto brandDto) {
        this.brandDto = brandDto;
    }

    public ProductTypeDto getProductTypeDto() {
        return productTypeDto;
    }

    public void setProductTypeDto(ProductTypeDto productTypeDto) {
        this.productTypeDto = productTypeDto;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public short getWarranty() {
        return warranty;
    }

    public void setWarranty(short warranty) {
        this.warranty = warranty;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public PromoCodeDto getPromoCodeDto() {
        return promoCodeDto;
    }

    public void setPromoCodeDto(PromoCodeDto promoCodeDto) {
        this.promoCodeDto = promoCodeDto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDto that = (ProductDto) o;
        return id == that.id &&
                quantity == that.quantity &&
                warranty == that.warranty &&
                available == that.available &&
                Double.compare(that.price, price) == 0 &&
                Objects.equals(brandDto, that.brandDto) &&
                Objects.equals(productTypeDto, that.productTypeDto) &&
                Objects.equals(description, that.description) &&
                Objects.equals(promoCodeDto, that.promoCodeDto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, brandDto, productTypeDto, description, quantity, warranty, available, price, promoCodeDto);
    }

    @Override
    public String toString() {
        return "ProductDto{" +
                "id=" + id +
                ", brandDto=" + brandDto +
                ", productTypeDto=" + productTypeDto +
                ", description='" + description + '\'' +
                ", quantity=" + quantity +
                ", warranty=" + warranty +
                ", available=" + available +
                ", price=" + price +
                ", promoCodeDto=" + promoCodeDto +
                '}';
    }
}
