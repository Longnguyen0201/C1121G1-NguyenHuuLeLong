package service.impl;

import models.Customer;
import repository.ICustomerRepository;
import repository.impl.CustomerRepository;
import service.ICustomerService;

import java.util.List;

public class CustomerService implements ICustomerService {
    private ICustomerRepository customerRepository = new CustomerRepository();
    @Override
    public List<Customer> selectAllCustomer() {
        return customerRepository.selectAllCustomer();
    }

    @Override
    public void createCustomer(Customer customer) {
        customerRepository.createCustomer(customer);
    }

    @Override
    public Customer selectCustomerById(Integer id) {
        return customerRepository.selectCustomerById(id);
    }
}
