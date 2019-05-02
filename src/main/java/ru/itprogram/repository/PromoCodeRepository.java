package ru.itprogram.repository;

import ru.itprogram.entity.dao.PromoCode;
import ru.itprogram.utils.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PromoCodeRepository implements Repository<PromoCode> {
    @Override
    public List<PromoCode> getAllEntity() {
        List<PromoCode> promoCodes = new ArrayList<>();
        CurrentConnection currentConnection = new CurrentConnection();
        try {
            Statement statement = currentConnection.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(SelectSql.SELECT_ALL_PROMO_CODE);
            while (resultSet.next()) {
                PromoCode promoCode = new PromoCode();
                promoCode.setId(resultSet.getInt("id"));
                promoCode.setCode(resultSet.getString("code"));
                promoCode.setDiscount(resultSet.getShort("discount"));
                promoCodes.add(promoCode);
            }
            resultSet.close();
            statement.close();
            currentConnection.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return promoCodes;
    }

    @Override
    public void saveEntity(PromoCode promoCode) {
        CurrentConnection currentConnection = new CurrentConnection();
        try {
            PreparedStatement preparedStatement = currentConnection.getConnection()
                    .prepareStatement(InsertSql.INSERT_PROMO_CODE);
            preparedStatement.setString(1, promoCode.getCode());
            preparedStatement.setShort(2, promoCode.getDiscount());
            preparedStatement.execute();
            preparedStatement.close();
            currentConnection.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
