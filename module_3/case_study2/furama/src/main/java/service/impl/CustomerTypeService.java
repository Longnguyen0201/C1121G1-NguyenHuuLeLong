package service.impl;

import models.CustomerType;
import repository.ICustomerTypeRepository;
import repository.impl.CustomerTypeRepository;
import service.ICustomerTypeService;

import java.util.List;

public class CustomerTypeService implements ICustomerTypeService {
    private ICustomerTypeRepository customerTypeRepository = new CustomerTypeRepository();
    @Override
    public List<CustomerType> getAllCustomerType() {
        return customerTypeRepository.getAllCustomerType();
    }
}
