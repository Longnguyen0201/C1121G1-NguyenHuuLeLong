package service;

import models.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> selectAllCustomer();

    void createCustomer(Customer customer);

    Customer selectCustomerById(Integer id);
}
