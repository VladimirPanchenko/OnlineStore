package ru.itprogram.entity.dao;

import java.util.Objects;

public class Product {
    private int id;
    private int brandId;
    private int productTypeId;
    private String description;
    private int quantity;
    private short warranty;
    private boolean available;
    private double price;
    private int promoCodId;

    public Product() {

    }

    public Product(int id, int brandId, int productTypeId, String description, int quantity,
                   short warranty, boolean available, double price, int promoCodId) {
        this.id = id;
        this.brandId = brandId;
        this.productTypeId = productTypeId;
        this.description = description;
        this.quantity = quantity;
        this.warranty = warranty;
        this.available = available;
        this.price = price;
        this.promoCodId = promoCodId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public int getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(int productTypeId) {
        this.productTypeId = productTypeId;
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

    public int getPromoCodId() {
        return promoCodId;
    }

    public void setPromoCodId(int promoCodId) {
        this.promoCodId = promoCodId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id &&
                brandId == product.brandId &&
                productTypeId == product.productTypeId &&
                quantity == product.quantity &&
                warranty == product.warranty &&
                available == product.available &&
                Double.compare(product.price, price) == 0 &&
                promoCodId == product.promoCodId &&
                Objects.equals(description, product.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, brandId, productTypeId, description, quantity, warranty, available, price, promoCodId);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", brandId=" + brandId +
                ", productTypeId=" + productTypeId +
                ", description='" + description + '\'' +
                ", quantity=" + quantity +
                ", warranty=" + warranty +
                ", available=" + available +
                ", price=" + price +
                ", promoCodId=" + promoCodId +
                '}';
    }
}
