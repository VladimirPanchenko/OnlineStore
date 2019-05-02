package ru.itprogram.service.converter.order;

import ru.itprogram.entity.dao.Order;
import ru.itprogram.entity.dto.OrderDto;
import ru.itprogram.repository.OrderRepository;
import ru.itprogram.service.converter.Converter;
import ru.itprogram.service.converter.product.ProductDtoToProduct;
import ru.itprogram.service.converter.user.UserDtoToUser;

import java.util.List;

public class OrderDtoToOrder implements Converter<Order, OrderDto> {
    @Override
    public Order conversion(OrderDto orderDto) {
        Order order = new Order();
        order.setId(getIdOrder(orderDto));
        order.setUserId(new UserDtoToUser().conversion(orderDto.getUserDto()).getId());
        order.setProductId(new ProductDtoToProduct().conversion(orderDto.getProductDto()).getId());
        order.setPaid(orderDto.isPaid());
        order.setClosed(orderDto.isClosed());
        order.setOrderDate(orderDto.getOrderDate());
        return order;
    }

    private int getIdOrder(OrderDto orderDto) {
        List<Order> orders = new OrderRepository().getAllEntity();
        return getId(orders, orderDto);
    }

    private int getId(List<Order> orders, OrderDto orderDto) {
        int tempId = 0;
        for (Order order : orders){
            if (order.getUserId() == new UserDtoToUser().conversion(orderDto.getUserDto()).getId()
                    && order.getProductId() == new ProductDtoToProduct()
                    .conversion(orderDto.getProductDto()).getId()
                    && order.isPaid() == orderDto.isPaid()
                    && order.isClosed() == orderDto.isClosed()
                    && order.getOrderDate().equals(orderDto.getOrderDate())) {
                tempId = order.getId();
            }
        }
        return tempId;
    }
}
