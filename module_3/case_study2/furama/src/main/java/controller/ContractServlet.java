package controller;

import DTO.ContractDTO;
import DTO.CustomerDTO;
import DTO.EmployeeDTO;
import DTO.ServiceDTO;
import models.contract.Contract;
import models.service.Service;
import repository.impl.CustomerTypeRepository;
import service.IContractService;
import service.impl.ContractService;
import service.impl.CustomerService;
import service.impl.EmployeeService;
import service.impl.ServicesService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ContractServlet", value = "/contracts")
public class ContractServlet extends HttpServlet {
    IContractService contractService = new ContractService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "edit":

                break;
            case "search":

                break;
            default:
                listContract(request, response);
                break;
        }

    }

    private void listContract(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CustomerService customerService = new CustomerService();
        List<CustomerDTO> customerDTOList = customerService.selectAllCustomer();
        EmployeeService employeeService = new EmployeeService();
        List<EmployeeDTO> employeeDTOList = employeeService.selectAllEmployee();
        ServicesService servicesService = new ServicesService();
        List<ServiceDTO> serviceList = servicesService.selectAllService();
        request.setAttribute("customerList", customerDTOList);
        request.setAttribute("employeeList", employeeDTOList);
        request.setAttribute("serviceList", serviceList);
        List<ContractDTO> contractDTOList = contractService.contractList();
        request.setAttribute("contractList", contractDTOList);
        request.getRequestDispatcher("contract/contractList.jsp").forward(request, response);


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
                createContract(request, response);
                break;
            case "edit":

                break;
            case "delete":

                break;
        }
    }

    private void createContract(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        Double deposit = Double.parseDouble(request.getParameter("deposit"));
        Double totalMoney = Double.parseDouble(request.getParameter("totalMoney"));
        Integer employeeId = Integer.parseInt(request.getParameter("employeeName"));
        Integer customerId = Integer.parseInt(request.getParameter("customerName"));
        Integer serviceId = Integer.parseInt(request.getParameter("serviceName"));
        Contract contract = new Contract(startDate, endDate, deposit, totalMoney, employeeId, customerId, serviceId);
        contractService.createContract(contract);

        List<ContractDTO> list = contractService.contractList();
        request.setAttribute("contractList",list);
        

        request.getRequestDispatcher("contract/contractList.jsp").forward(request,response);

    }
}
