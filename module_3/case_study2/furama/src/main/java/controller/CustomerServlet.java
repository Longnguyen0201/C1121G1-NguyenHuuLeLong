package controller;

import DTO.CustomerDTO;
import DTO.EmployeeDTO;
import models.customer.Customer;
import models.customer.CustomerType;
import service.ICustomerService;
import service.ICustomerTypeService;
import service.impl.CustomerService;
import service.impl.CustomerTypeService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "CustomerServlet", value = "/customers")
public class CustomerServlet extends HttpServlet {
    private ICustomerService customerService = new CustomerService();
    private ICustomerTypeService customerTypeService = new CustomerTypeService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                formCreateCustomer(request, response);
                break;
            case "edit":
                formEditCustomer(request, response);
                break;
            case "search":
                searchCustomer(request,response);
                break;
            default:
                listAllCustomer(request, response);
                break;
        }

    }

    private void searchCustomer(HttpServletRequest request, HttpServletResponse response) {
        String search = request.getParameter("searchCustomer");
        List<CustomerDTO> searchCustomerList = customerService.searchCustomerByName(search);
        request.setAttribute("customerList", searchCustomerList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/customerList.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void formEditCustomer(HttpServletRequest request, HttpServletResponse response) {

        Integer id = Integer.parseInt(request.getParameter("id"));
        Customer customer = customerService.selectCustomerById(id);
        List<CustomerType> customerTypeList = customerTypeService.getAllCustomerType();
        request.setAttribute("customerTypeList", customerTypeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/editCustomer.jsp");
        request.setAttribute("customer", customer);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void formCreateCustomer(HttpServletRequest request, HttpServletResponse response) {
        List<CustomerType> customerTypeList = customerTypeService.getAllCustomerType();
        request.setAttribute("customerTypeList", customerTypeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/createCustomer.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void listAllCustomer(HttpServletRequest request, HttpServletResponse response) {
        List<CustomerDTO> customerList = customerService.selectAllCustomer();
        request.setAttribute("customerList", customerList);
        try {
            request.getRequestDispatcher("customer/customerList.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createCustomer(request, response);
                break;
            case "edit":
                editCustomer(request, response);
                break;
            case "delete":
                deleteCustomer(request, response);
                break;
        }
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.parseInt(request.getParameter("idDelete"));
        customerService.deleteCustomerById(id);

        try {
            List<CustomerDTO> customerList = customerService.selectAllCustomer();
            request.setAttribute("customerList", customerList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("customer/customerList.jsp");
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void editCustomer(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.parseInt(request.getParameter("id"));
        String code = request.getParameter("customerCode");
        String name = request.getParameter("customerName");
        String birthday = request.getParameter("birthday");
        Integer gender = Integer.parseInt(request.getParameter("gender"));
        String idCard = request.getParameter("idCard");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Integer customerTypeId = Integer.parseInt(request.getParameter("customerType"));
        Customer customer = new Customer(id, code, name, birthday, gender, idCard, phone, email, address, customerTypeId);

        customerService.updateCustomer(customer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/editCustomer.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void createCustomer(HttpServletRequest request, HttpServletResponse response) {
        String code = request.getParameter("customerCode");
        String name = request.getParameter("customerName");
        String birthday = request.getParameter("birthday");
        String idCard = request.getParameter("idCard");
        Integer gender = Integer.parseInt(request.getParameter("gender"));
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Integer customerTypeId = Integer.parseInt(request.getParameter("customerType"));
        Customer customer = new Customer(code, name, birthday, gender, idCard, phone, email, address, customerTypeId);

        Map<String,String> map = customerService.createCustomer(customer);
        if (map.isEmpty()){
            request.setAttribute("message", "New Customer was create ");
            try {
                request.getRequestDispatcher("customer/createCustomer.jsp").forward(request,response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        }else {
            List<CustomerType> customerTypeList = customerTypeService.getAllCustomerType();
            request.setAttribute("customerTypeList", customerTypeList);

            request.setAttribute("errors",map);;
            try {
                request.getRequestDispatcher("customer/createCustomer.jsp").forward(request,response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }

        }

//        try {
//            customerService.createCustomer(customer);
//            RequestDispatcher dispatcher = request.getRequestDispatcher("customer/createCustomer.jsp");
//            request.setAttribute("message", "New customer was create ");
//            dispatcher.forward(request, response);
//        } catch (ServletException | IOException e) {
//            e.printStackTrace();
//        }

    }
}
