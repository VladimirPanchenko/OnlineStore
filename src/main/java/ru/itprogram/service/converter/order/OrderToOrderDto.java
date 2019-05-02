package ru.itprogram.service.converter.order;

import ru.itprogram.entity.dao.Order;
import ru.itprogram.entity.dao.Product;
import ru.itprogram.entity.dao.User;
import ru.itprogram.entity.dto.OrderDto;
import ru.itprogram.repository.ProductRepository;
import ru.itprogram.repository.UserRepository;
import ru.itprogram.service.converter.Converter;
import ru.itprogram.service.converter.product.ProductToProductDto;
import ru.itprogram.service.converter.user.UserToUserDto;

import java.util.List;

public class OrderToOrderDto implements Converter<OrderDto, Order> {
    @Override
    public OrderDto conversion(Order order) {
        OrderDto orderDto = new OrderDto();
        UserRepository userRepository = new UserRepository();
        List<User> users = userRepository.getAllEntity();
        User user = null;
        for (User findUser : users) {
            if (findUser.getId() == order.getUserId()) {
                user = findUser;
            }
        }
        ProductRepository productRepository = new ProductRepository();
        List<Product> products = productRepository.getAllEntity();
        Product product = null;
        for (Product findProduct : products) {
            if (findProduct.getId() == order.getProductId()) {
                product = findProduct;
            }
        }
        orderDto.setUserDto(new UserToUserDto().conversion(user));
        orderDto.setProductDto(new ProductToProductDto().conversion(product));
        orderDto.setPaid(order.isPaid());
        orderDto.setClosed(order.isClosed());
        orderDto.setOrderDate(order.getOrderDate());
        return orderDto;
    }
}
