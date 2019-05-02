package ru.itprogram.service;

import ru.itprogram.entity.dao.Order;
import ru.itprogram.entity.dto.OrderDto;
import ru.itprogram.repository.OrderRepository;
import ru.itprogram.service.converter.order.OrderDtoToOrder;
import ru.itprogram.service.converter.order.OrderToOrderDto;

import java.util.ArrayList;
import java.util.List;

public class OrderService implements Service<OrderDto> {
    @Override
    public List<OrderDto> getAll() {
        List<Order> orders = new OrderRepository().getAllEntity();
        List<OrderDto> orderDtoList = new ArrayList<>();
        for (Order order : orders) {
            orderDtoList.add(new OrderToOrderDto().conversion(order));
        }
        return orderDtoList;
    }

    @Override
    public void add(OrderDto orderDto) {
        new OrderRepository().saveEntity(new OrderDtoToOrder().conversion(orderDto));
    }
}
