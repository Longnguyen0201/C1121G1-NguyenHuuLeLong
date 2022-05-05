package service;

import DTO.CustomerDTO;
import models.customer.Customer;

import java.util.List;
import java.util.Map;

public interface ICustomerService {
    List<CustomerDTO> selectAllCustomer();

    Map<String, String> createCustomer(Customer customer);

    Customer selectCustomerById(Integer id);

    boolean updateCustomer(Customer customer);

    boolean deleteCustomerById(Integer id);

    List<CustomerDTO> searchCustomerByName(String search);
}
