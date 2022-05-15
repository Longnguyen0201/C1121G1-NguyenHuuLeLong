package com.codegym.controller;

import com.codegym.dto.CustomerDto;
import com.codegym.model.customer.Customer;
import com.codegym.model.customer.CustomerType;
import com.codegym.services.customer.ICustomerService;
import com.codegym.services.customer.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/customers")
@CrossOrigin("*")
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;

    @Autowired
    private ICustomerTypeService iCustomerTypeService;

    @ModelAttribute("customerTypeObj")
    public List<CustomerType> customerType() {
        return iCustomerTypeService.findAll();
    }

    @ModelAttribute("genders")
    public List<Integer> gender() {
        return Arrays.asList(1, 2, 3);
    }


    @GetMapping(value = { "/list"})
    public ResponseEntity<List<Customer>> showListCustomer(@PageableDefault(value = 10) Pageable pageable) {
        Page<Customer> customerPage = iCustomerService.findAllPaing(pageable);
        List<Customer> customerList = customerPage.toList();
        return new ResponseEntity<>(customerList, HttpStatus.OK);
    }

//    @GetMapping(value = "/create")
//    public ModelAndView showFormCreateCustomer() {
//        ModelAndView modelAndView = new ModelAndView("/customer/create");
//        modelAndView.addObject("customerDto", new CustomerDto());
//        return modelAndView;
//    }
//
    @PostMapping(value = "/save")
    public ResponseEntity<Map<String,String>> addCustomer(@Valid @RequestBody CustomerDto customerDto,
                                                     BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            Map<String,String> errorMap = bindingResult.getFieldErrors()
                    .stream().collect(Collectors.toMap(e -> e.getField(), e -> e.getDefaultMessage()));
            return new ResponseEntity<>(errorMap,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        CustomerType customerType = customerDto.getCustomerType();
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        customer.setCustomerType(customerType);
        iCustomerService.save(customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/edit/{id}")
    public ResponseEntity<CustomerDto> showEditForm(@PathVariable Integer id) {
        Customer customer = iCustomerService.findById(id);
        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(customer, customerDto);
        customerDto.setCustomerType(customer.getCustomerType());
        return new ResponseEntity<>(customerDto,HttpStatus.OK);
    }

    @PostMapping(value = "/update/{id}")
    public ResponseEntity<Map<String,String>> editCustomer(@Valid @RequestBody CustomerDto customerDto,
                                                           BindingResult bindingResult,
                                                           @PathVariable Integer id) {
        System.out.println("hihihi");
        if (bindingResult.hasFieldErrors()) {
            Map<String,String> errorMap = bindingResult.getFieldErrors()
                    .stream().collect(Collectors.toMap(e -> e.getField(), e -> e.getDefaultMessage()));
            return new ResponseEntity<>(errorMap,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
//        customer.setCustomerId(id);
        customer.setCustomerType(customerDto.getCustomerType());
        iCustomerService.save(customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable(value = "id") Integer id) {
        iCustomerService.remove(id);
        String message = "Xóa thành công";
        return new ResponseEntity<>(HttpStatus.OK) ;
    }
}
