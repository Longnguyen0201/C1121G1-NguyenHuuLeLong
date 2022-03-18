package controller;

import DTO.EmployeeDTO;
import models.Division;
import models.EducationDegree;
import models.Employee;
import models.Position;
import service.impl.EmployeeService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "EmployeeServlet", value = "/employees")
public class EmployeeServlet extends HttpServlet {
    EmployeeService employeeService = new EmployeeService();
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
                fromCreateEmployee(request,response);
                break;
            case "edit":

                break;
            case "view":
                break;
            case "search":
                break;
            default:
                listAllEmployee(request,response);
                break;
        }
    }

    private void fromCreateEmployee(HttpServletRequest request, HttpServletResponse response) {
        List<Position> positionList = employeeService.getAllPosition();
        request.setAttribute("positionList",positionList);
        List<EducationDegree> educationDegreeList = employeeService.getAllEducation();
        request.setAttribute("educationDegreeList",educationDegreeList);
        List<Division> divisionList = employeeService.getAllDivision();
        request.setAttribute("divisionList",divisionList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/createEmployee.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }

    }

    private void listAllEmployee(HttpServletRequest request, HttpServletResponse response) {
        List<EmployeeDTO>  employeeList = employeeService.selectAllEmployee();
        request.setAttribute("employeeList", employeeList);
        try {
            request.getRequestDispatcher("employee/employeeList.jsp").forward(request,response);
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
                break;
            case "edit":
                break;
            case "delete":
                break;
        }
    }
}
