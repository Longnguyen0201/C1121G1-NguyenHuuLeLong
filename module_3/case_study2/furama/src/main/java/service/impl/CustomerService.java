package service.impl;

import DTO.CustomerDTO;
import models.customer.Customer;
import repository.ICustomerRepository;
import repository.impl.CustomerRepository;
import service.ICustomerService;
import service.Regex;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CustomerService implements ICustomerService {
    private ICustomerRepository customerRepository = new CustomerRepository();
    Regex regex = new Regex();

    @Override
    public List<CustomerDTO> selectAllCustomer() {
        return customerRepository.selectAllCustomer();
    }

    @Override
    public Map<String, String> createCustomer(Customer customer) {
        Map<String, String> map = new HashMap<>();
        boolean flag = true;
        if (!customer.getCode().matches(regex.REGEX_CODE_CUSTOMER)) {
            flag = false;
            map.put("code", "Không đúng định dạng (ví dụ:KH-1234)");
        }

        if (!customer.getName().matches(regex.REGEX_NAME)) {
            flag = false;
            map.put("name", "Không đúng định dạng viết hoa kí tự đầu,có dấu(ví dụ:Nguyễn Long)");
        }
//        if (!customer.getBirthday().matches(regex.REGEX_DATE)) {
//            flag = false;
//            map.put("birthday", "Không đúng định dạng yyyy-mm-dd (ví dụ:2021-12-02)");
//        }
        if (!customer.getIdCard().matches(regex.REGEX_NUMBER)) {
            flag = false;
            map.put("idCard", "Không đúng định dạng số");
        }
        if (!customer.getPhone().matches(regex.REGEX_PHONE)) {
            flag = false;
            map.put("phone", "Sai định dạng số điện thoại (090|091|(84)+)");
        }
        if (!customer.getEmail().matches(regex.REGEX_EMAIL)) {
            flag = false;
            map.put("email", "Sai định dạng email (ví dụ: test@gmail.com)");
        }
        if (flag){
            customerRepository.createCustomer(customer);
        }
        return map;

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

    @Override
    public List<CustomerDTO> searchCustomerByName(String search) {
        return customerRepository.searchCustomerByName(search);
    }
}
