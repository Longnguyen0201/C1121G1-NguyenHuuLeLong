package repository;

import models.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> selectAllCustomer();

    void createCustomer(Customer customer);

    Customer selectCustomerById(Integer id);
}
