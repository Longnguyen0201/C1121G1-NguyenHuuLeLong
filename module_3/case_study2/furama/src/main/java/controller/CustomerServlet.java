package controller;

import models.Customer;
import service.ICustomerService;
import service.impl.CustomerService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerServlet", value = "/customers")
public class CustomerServlet extends HttpServlet {
    private ICustomerService customerService = new CustomerService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
            case "view":
                break;
            case "search":
                break;
            default:
                listAllCustomer(request, response);
                break;
        }

    }

    private void formEditCustomer(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.parseInt(request.getParameter("id"));
        Customer customer = customerService.selectCustomerById(id);

    }

    private void formCreateCustomer(HttpServletRequest request, HttpServletResponse response) {
//        List<Customer> customerTypeList = customerService.getAllCustomerType();
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/createCustomer.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }


    private void listAllCustomer(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> customerList = customerService.selectAllCustomer();
        request.setAttribute("customerList", customerList);
        try {
            request.getRequestDispatcher("customer/customerList.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                CreateCustomer(request, response);
                break;

        }
    }

    private void CreateCustomer(HttpServletRequest request, HttpServletResponse response) {
        String code = request.getParameter("customerCode");
        String name = request.getParameter("customerName");
        String birthday = request.getParameter("birthday");
        Integer gender = Integer.parseInt(request.getParameter("gender"));
        String idCard = request.getParameter("idCard");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Integer customerType = Integer.parseInt(request.getParameter("customerType"));
        Customer customer = new Customer(code, name, birthday, gender, idCard, phone, email, address, customerType);

        try {
            customerService.createCustomer(customer);
            RequestDispatcher dispatcher = request.getRequestDispatcher("customer/createCustomer.jsp");
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }

    }
}
