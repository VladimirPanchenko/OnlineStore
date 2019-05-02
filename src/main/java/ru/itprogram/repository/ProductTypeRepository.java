package ru.itprogram.repository;

import ru.itprogram.entity.dao.ProductType;
import ru.itprogram.utils.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductTypeRepository implements Repository<ProductType> {
    @Override
    public List<ProductType> getAllEntity() {
        List<ProductType> productTypes = new ArrayList<>();
        CurrentConnection currentConnection = new CurrentConnection();
        try {
            Statement statement = currentConnection.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(SelectSql.SELECT_ALL_PRODUCT_TYPE);
            while (resultSet.next()) {
                ProductType productType = new ProductType();
                productType.setId(resultSet.getInt("id"));
                productType.setType(resultSet.getString("type"));
                productTypes.add(productType);
            }
            resultSet.close();
            statement.close();
            currentConnection.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productTypes;
    }

    @Override
    public void saveEntity(ProductType productType) {
        CurrentConnection currentConnection = new CurrentConnection();
        try {
            PreparedStatement preparedStatement = currentConnection.getConnection()
                    .prepareStatement(InsertSql.INSERT_PRODUCT_TYPE);
            preparedStatement.setString(1, productType.getType());
            preparedStatement.execute();
            preparedStatement.close();
            currentConnection.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
