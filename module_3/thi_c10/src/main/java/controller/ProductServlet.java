package controller;

import model.Catelogy;
import model.Product;
import service.IProdcutService;
import service.impl.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/product")
public class ProductServlet extends HttpServlet {
    IProdcutService iProdcutService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "search":
                searchProduct(request, response);
                break;
            default:
                displayProduct(request, response);
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createProduct(request, response);
                break;
            case "edit":
                editProduct(request, response);
                break;
            case "delete":
                deleteProduct(request, response);
                break;
            default:

        }

    }

    private void displayProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> productList = iProdcutService.getAllProduct();
        List<Catelogy> catelogyList = iProdcutService.getAllCatelogy();
        request.setAttribute("list", productList);
        request.setAttribute("catelogy", catelogyList);
        request.getRequestDispatcher("list.jsp").forward(request, response);

    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        Integer amount = Integer.parseInt(request.getParameter("amount"));
        String color = request.getParameter("color");
        String description = request.getParameter("description");
        Catelogy catelogy = new Catelogy(Integer.parseInt(request.getParameter("catelogy")));
        Product product = new Product(id, name, price, amount, color, description, catelogy);
        iProdcutService.inserInto(product);
        response.sendRedirect("product");


    }

    private void editProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer id = Integer.parseInt(request.getParameter("id_modal_edit"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        Integer amount = Integer.parseInt(request.getParameter("amount"));
        String color = request.getParameter("color");
        String description = request.getParameter("description");
        Catelogy catelogy = new Catelogy(Integer.parseInt(request.getParameter("category_id")));
        Product product = new Product(id, name, price, amount, color, description, catelogy);
        iProdcutService.update(product);
        response.sendRedirect("product");

    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer id = Integer.parseInt(request.getParameter("id_modal_delete"));
        iProdcutService.delete(id);
        response.sendRedirect("product");

    }

    private void searchProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String search = request.getParameter("search");
        List<Product> productList = iProdcutService.searchProduct(search);
        List<Catelogy> catelogyList = iProdcutService.getAllCatelogy();
        request.setAttribute("list", productList);
        request.setAttribute("catelogy", catelogyList);
        request.getRequestDispatcher("list.jsp").forward(request, response);


    }


}
