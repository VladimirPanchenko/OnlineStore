package ru.itprogram.repository;

import ru.itprogram.entity.dao.Order;
import ru.itprogram.utils.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OrderRepository implements Repository<Order> {
    @Override
    public List<Order> getAllEntity() {
        List<Order> orders = new ArrayList<>();
        CurrentConnection currentConnection = new CurrentConnection();
        try {
            Statement statement = currentConnection.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(SelectSql.SELECT_ALL_CART);
            while (resultSet.next()) {
                Order order = new Order();
                order.setId(resultSet.getInt("id"));
                order.setUserId(resultSet.getInt("user_id"));
                order.setProductId(resultSet.getInt("product_id"));
                order.setPaid(resultSet.getBoolean("paid"));
                order.setClosed(resultSet.getBoolean("is_closed"));
                order.setOrderDate(resultSet.getTimestamp("order_date").toLocalDateTime());
                orders.add(order);
            }
            resultSet.close();
            statement.close();
            currentConnection.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public void saveEntity(Order order) {
        CurrentConnection currentConnection = new CurrentConnection();
        try {
            PreparedStatement preparedStatement = currentConnection.getConnection()
                    .prepareStatement(InsertSql.INSERT_CART);
            preparedStatement.setInt(1, order.getUserId());
            preparedStatement.setInt(2, order.getProductId());
            preparedStatement.setBoolean(3, order.isPaid());
            preparedStatement.setBoolean(4, order.isClosed());
            preparedStatement.execute();
            preparedStatement.close();
            currentConnection.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
