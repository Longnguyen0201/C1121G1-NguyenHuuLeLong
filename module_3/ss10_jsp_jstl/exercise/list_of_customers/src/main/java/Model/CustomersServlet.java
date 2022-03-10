package Model;

import service.CustomerServiceImlp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CustomersServlet", value = "/customer")
public class CustomersServlet extends HttpServlet {
    CustomerServiceImlp customerServiceImlp = new CustomerServiceImlp();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("customersList", customerServiceImlp.findAll());
        request.getRequestDispatcher("customers.jsp").forward(request,response);
    }
}
