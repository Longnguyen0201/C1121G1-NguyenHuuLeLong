package repository.impl;

import models.Customer;
import repository.BaseRepository;
import repository.ICustomerRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {
    private BaseRepository baseRepository = new BaseRepository();
    private static final String SQL_SELECT_ALL_CUSTOMER = "select customer_id,customer_code,customer_name,customer_birthday,customer_gender,customer_id_card, customer_phone,customer_email,\n" +
            "customer_address,customer_type.customer_type_name from customer\n" +
            "inner join customer_type on customer.customer_type_id = customer_type.customer_type_id\n" +
            "order by customer_id;";
    private static final String SQL_CREATE_CUSTOMER = "insert into customer (customer_code, customer_name, " +
            "customer_birthday, customer_gender,customer_id_card, customer_phone,customer_email,customer_address,customer_type_id)\n" +
            "value (?,?,?,?,?,?,?,?,?);";
    private  static final  String SQL_SELECT_CUSTOMER_BY_ID = "";

    @Override
    public List<Customer> selectAllCustomer() {
        List<Customer> customerList = new ArrayList<>();
        Connection connection = baseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_ALL_CUSTOMER);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer id = resultSet.getInt("customer_id");
                String code = resultSet.getString("customer_code");
                String name = resultSet.getString("customer_name");
                String birthday = resultSet.getString("customer_birthday");
                Integer gender = resultSet.getInt("customer_gender");
                String idCard = resultSet.getString("customer_id_card");
                String phone = resultSet.getString("customer_phone");
                String email = resultSet.getString("customer_email");
                String address = resultSet.getString("customer_address");
                String customerTypeName = resultSet.getString("customer_type_name");
                customerList.add(new Customer(id, code, name, birthday, gender, idCard, phone, email, address, customerTypeName));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return customerList;
    }

    @Override
    public void createCustomer(Customer customer) {
        Connection connection = baseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_CREATE_CUSTOMER);
            preparedStatement.setString(1, customer.getCode());
            preparedStatement.setString(2, customer.getName());
            preparedStatement.setString(3, customer.getBirthday());
            preparedStatement.setInt(4, customer.getGender());
            preparedStatement.setString(5, customer.getIdCard());
            preparedStatement.setString(6, customer.getPhone());
            preparedStatement.setString(7, customer.getEmail());
            preparedStatement.setString(8, customer.getAddress());
            preparedStatement.setInt(9, customer.getCustomerType());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Customer selectCustomerById(Integer id) {
        Customer customer;
        Connection connection = baseRepository.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement()
        return null;
    }

}
