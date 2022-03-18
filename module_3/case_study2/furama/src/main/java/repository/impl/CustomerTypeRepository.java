package repository.impl;

import models.CustomerType;
import repository.BaseRepository;
import repository.ICustomerTypeRepository;

import javax.servlet.RequestDispatcher;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerTypeRepository implements ICustomerTypeRepository {
    BaseRepository baseRepository = new BaseRepository();
    @Override
    public List<CustomerType> getAllCustomerType() {
        List<CustomerType> list = new ArrayList<>();
        Connection connection = baseRepository.getConnection();
        try {
            PreparedStatement preparedStatement =connection.prepareStatement("select * from customer_type;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                list.add(new CustomerType(resultSet.getInt("customer_type_id"),
                        resultSet.getString("customer_type_name")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        return list;
    }
}
