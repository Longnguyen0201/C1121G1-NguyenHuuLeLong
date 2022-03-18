package repository;

import DTO.CustomerDTO;
import models.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<CustomerDTO> selectAllCustomer();

    void createCustomer(Customer customer);

    Customer selectCustomerById(Integer id);

    boolean updateCustomer(Customer customer);

    boolean deleteCustomerById(Integer id);
}
