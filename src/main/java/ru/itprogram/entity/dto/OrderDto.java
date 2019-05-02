package ru.itprogram.entity.dto;

import java.time.LocalDateTime;
import java.util.Objects;

public class OrderDto {
    private UserDto userDto;
    private ProductDto productDto;
    private boolean paid;
    private boolean closed;
    private LocalDateTime orderDate;

    public OrderDto() {

    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }

    public ProductDto getProductDto() {
        return productDto;
    }

    public void setProductDto(ProductDto productDto) {
        this.productDto = productDto;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public OrderDto(UserDto userDto, ProductDto productDto, boolean paid, boolean closed,
                    LocalDateTime orderDate) {
        this.userDto = userDto;
        this.productDto = productDto;
        this.paid = paid;
        this.closed = closed;
        this.orderDate = orderDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDto orderDto = (OrderDto) o;
        return paid == orderDto.paid &&
                closed == orderDto.closed &&
                Objects.equals(userDto, orderDto.userDto) &&
                Objects.equals(productDto, orderDto.productDto) &&
                Objects.equals(orderDate, orderDto.orderDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userDto, productDto, paid, closed, orderDate);
    }

    @Override
    public String toString() {
        return "OrderDto{" +
                "userDto=" + userDto +
                ", productDto=" + productDto +
                ", paid=" + paid +
                ", closed=" + closed +
                ", orderDate=" + orderDate +
                '}';
    }
}
