package service.impl;

import DTO.CustomerDTO;
import models.Customer;
import repository.ICustomerRepository;
import repository.impl.CustomerRepository;
import service.ICustomerService;

import java.util.List;

public class CustomerService implements ICustomerService {
    private ICustomerRepository customerRepository = new CustomerRepository();
    @Override
    public List<CustomerDTO> selectAllCustomer() {
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

    @Override
    public boolean updateCustomer(Customer customer) {
        return customerRepository.updateCustomer(customer);
    }

    @Override
    public boolean deleteCustomerById(Integer id) {
        return customerRepository.deleteCustomerById(id);
    }
}
