package controller;

import DTO.ProductDTO;
import models.Category;
import models.Product;
import service.IProductService;
import service.impl.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/products")
public class ProductServlet extends HttpServlet {
    IProductService productService = new ProductService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                formCreate(request, response);
                break;
            case "edit":
                formEdit(request, response);
                break;
            case "search":
                search(request, response);
                break;
            default:
                display(request, response);

        }
    }

    private void search(HttpServletRequest request, HttpServletResponse response) {
        String search = request.getParameter("search");
        List<ProductDTO> searchList = productService.searchByName(search);
        request.setAttribute("list", searchList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void formEdit(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.selectById(id);
        List<Category> categoryList = productService.getAllCategory();
        request.setAttribute("categoryList", categoryList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("edit.jsp");
        request.setAttribute("product", product);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void formCreate(HttpServletRequest request, HttpServletResponse response) {
        List<Category> categoryList = productService.getAllCategory();
        request.setAttribute("categoryList", categoryList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void display(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ProductDTO> productList = productService.getAllProduct();
        List<Category> categoryList = productService.getAllCategory();
        request.setAttribute("list", productList);
        request.setAttribute("catelogy", categoryList);
        request.getRequestDispatcher("list.jsp").forward(request, response);
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
                create(request, response);
                break;
            case "edit":
                edit(request, response);
                break;
            case "delete":
                delete(request, response);
                break;
            default:

        }
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        Double price = Double.parseDouble(request.getParameter("price"));
        Integer quantity = Integer.parseInt(request.getParameter("quantity"));
        String color = request.getParameter("color");
        Integer categoryId = Integer.parseInt(request.getParameter("category"));
        Product product = new Product(id,name,price,quantity,color,categoryId);
        productService.update(product);
        request.setAttribute("message", "Delete product was create ");
        List<ProductDTO> productList = productService.getAllProduct();
        request.setAttribute("list", productList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.parseInt(request.getParameter("id_modal_delete"));
        productService.delete(id);
        request.setAttribute("message", " product was delete ");
        List<ProductDTO> productList = productService.getAllProduct();
        request.setAttribute("list", productList);
        try {

            RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void create(HttpServletRequest request, HttpServletResponse response) {

        Integer quantity = Integer.parseInt(request.getParameter("quantity"));
        String color = request.getParameter("color");
        Integer categoryId = Integer.parseInt(request.getParameter("category"));
        Product product = new Product(name,price,quantity,color,categoryId);
        productService.createProduct(product);
        request.setAttribute("message", "New product was create ");
        List<ProductDTO> productList = productService.getAllProduct();
        request.setAttribute("list", productList);
        try {

            request.getRequestDispatcher("list.jsp").forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
