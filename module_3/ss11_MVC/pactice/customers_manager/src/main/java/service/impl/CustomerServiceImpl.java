package service.impl;

import model.Customer;
import repository.CustomerRepository;
import repository.impl.CustomerRepositoryImpl;
import service.CustomerService;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository = new CustomerRepositoryImpl();
    @Override
    public List<Customer> findAll() {
       List<Customer> customers = customerRepository.findAll();
       return  customers;
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Customer findById(int id) {
        Customer customer = this.customerRepository.findById(id);
        return customer;
    }

    @Override
    public void update(int id, Customer customer) {
        if(customer.getName().equals("")) {
            System.out.println("Tên không được để trống");
            return;
        }
        if(this.customerRepository.findById(id) == null) {
            System.out.println("id không tồn tạo trong database");
            return;
        }
        this.customerRepository.update(id,customer);

    }
    @Override
    public void remove(int id) {
        customerRepository.remove(id);
    }
}
