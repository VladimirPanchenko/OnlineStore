package ru.itprogram.repository;

import ru.itprogram.entity.dao.Brand;
import ru.itprogram.utils.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BrandRepository implements Repository<Brand> {
    @Override
    public List<Brand> getAllEntity() {
        List<Brand> brands = new ArrayList<>();
        CurrentConnection currentConnection = new CurrentConnection();
        Statement statement;
        try {
            statement = currentConnection.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(SelectSql.SELECT_ALL_BRAND);
            while (resultSet.next()) {
                Brand brand = new Brand();
                brand.setId(resultSet.getInt("id"));
                brand.setName(resultSet.getString("name"));
                brands.add(brand);
            }
            resultSet.close();
            statement.close();
            currentConnection.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return brands;
    }

    @Override
    public void saveEntity(Brand brand) {
        CurrentConnection currentConnection = new CurrentConnection();
        try {
            PreparedStatement preparedStatement = currentConnection.getConnection()
                    .prepareStatement(InsertSql.INSERT_BRAND);
            preparedStatement.setString(1, brand.getName());
            preparedStatement.execute();
            preparedStatement.close();
            currentConnection.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
