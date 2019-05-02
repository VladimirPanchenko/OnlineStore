package ru.itprogram.provider;

import ru.itprogram.entity.dto.OrderDto;
import ru.itprogram.entity.dto.UserDto;
import ru.itprogram.service.OrderService;

import java.util.List;

public class PurchaseHistory {
    private List<OrderDto> orderDtoList;
    private UserDto userDto;

    public PurchaseHistory(UserDto userDto) {
        this.userDto = userDto;
        orderDtoList = new OrderService().getAll();
    }

    public void printAllHistory() {
        int count = 0;
        System.out.println("Покупки совершённые вами:");
        for (OrderDto orderDto : orderDtoList) {
            if (orderDto.getUserDto().equals(userDto)) {
                ++count;
                System.out.println("ID продукта: [" + orderDto.getProductDto().getId()
                        + "] Бренд: [" + orderDto.getProductDto().getBrandDto().getName()
                        + "] Тип продукта: [" + orderDto.getProductDto()
                        .getProductTypeDto().getType()
                        + "] Описание: [" + orderDto.getProductDto().getDescription()
                        + "] Гарантия: [" + orderDto.getProductDto().getWarranty()
                        + "] Цена: [" + orderDto.getProductDto().getPrice()
                        + "] Оплачен ли товар: [" + orderDto.isPaid()
                        + "] Дата покупки: [" + orderDto.getOrderDate());
            }
        }
        if (count == 0) {
            System.out.println("Похоже, что вы ещё не совершали покупок.");
        }
    }
}
