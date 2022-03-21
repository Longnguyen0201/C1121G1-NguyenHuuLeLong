package controller;

import DTO.ServiceDTO;
import models.service.RentType;
import models.service.Service;
import models.service.ServiceType;
import service.IServicesService;
import service.impl.ServicesService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServiceServlet", value = "/services")
public class ServiceServlet extends HttpServlet {
    IServicesService servicesService = new ServicesService();

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
                formCreateService(request, response);
                break;
            case "edit":
                formEditService(request, response);
                break;
            case "search":

            default:
                listAllService(request, response);
                break;
        }
    }

    private void formEditService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        Service service = servicesService.selectServiceById(id);
        request.setAttribute("service", service);
        List<RentType> rentTypeList = servicesService.getAllRentType();
        request.setAttribute("rentTypeList", rentTypeList);
        List<ServiceType> serviceTypeList = servicesService.getAllServiceType();
        request.setAttribute("serviceTypeList", serviceTypeList);
        request.getRequestDispatcher("service/editService.jsp").forward(request, response);

    }

    private void formCreateService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<RentType> rentTypeList = servicesService.getAllRentType();
        request.setAttribute("rentTypeList", rentTypeList);
        Integer idType = Integer.parseInt(request.getParameter("idType"));
        request.setAttribute("idType", idType);
        List<ServiceType> serviceTypeList = servicesService.getAllServiceType();
        request.setAttribute("serviceTypeList", serviceTypeList);
        request.getRequestDispatcher("service/createService.jsp").forward(request, response);

    }

    private void listAllService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ServiceDTO> serviceList = servicesService.selectAllService();
        request.setAttribute("serviceList", serviceList);
        List<ServiceType> serviceTypeList = servicesService.getAllServiceType();
        request.setAttribute("serviceTypeList", serviceTypeList);
        request.getRequestDispatcher("service/serviceList.jsp").forward(request, response);


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
                createService(request, response);
                break;
            case "edit":
                editService(request, response);
                break;
            case "delete":
                deleteService(request,response);

                break;
        }
    }

    private void deleteService(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.parseInt(request.getParameter("idDelete"));
        servicesService.deleteService(id);
        List<ServiceDTO> list = servicesService.selectAllService();
        request.setAttribute("serviceList",list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("service/serviceList.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void editService(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.parseInt(request.getParameter("id"));
        String code = request.getParameter("serviceCode");
        String name = request.getParameter("serviceName");
        Integer area = Integer.parseInt(request.getParameter("serviceArea"));
        Double cost = Double.parseDouble(request.getParameter("serviceCost"));
        Integer maxPeople = Integer.parseInt(request.getParameter("serviceMaxPeople"));
        Integer rentType = Integer.parseInt(request.getParameter("rentType"));
        Integer serviceType = Integer.parseInt(request.getParameter("serviceType"));
        String standardRoom = request.getParameter("standardRoom");
        String description = request.getParameter("description");
        Double areaPool = Double.parseDouble(request.getParameter("areaPool"));
        Integer floors = Integer.parseInt(request.getParameter("floors"));
        Service service = new Service(id, code, name, area, cost, maxPeople, rentType, serviceType, standardRoom, description, areaPool, floors);
        servicesService.updateService(service);
        RequestDispatcher dispatcher = request.getRequestDispatcher("service/editService.jsp");
        request.setAttribute("message", "Service was update");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code = request.getParameter("serviceCode");
        String name = request.getParameter("serviceName");
        Integer area = Integer.parseInt(request.getParameter("serviceArea"));
        Double cost = Double.parseDouble(request.getParameter("serviceCost"));
        Integer maxPeople = Integer.parseInt(request.getParameter("serviceMaxPeople"));
        Integer rentType = Integer.parseInt(request.getParameter("rentType"));
        Integer serviceType = Integer.parseInt(request.getParameter("serviceType"));
        String standardRoom = request.getParameter("standardRoom");
        String description = request.getParameter("description");
        Double areaPool;
        Integer floors;
        switch (serviceType) {
            case 1:
                areaPool = Double.parseDouble(request.getParameter("areaPool"));
                floors = Integer.parseInt(request.getParameter("floors"));
                Service villa = new Service(code, name, area, cost, maxPeople, rentType, serviceType,
                        standardRoom, description, areaPool, floors);
                servicesService.createVilla(villa);
                break;
            case 2:
                floors = Integer.parseInt(request.getParameter("floors"));
                Service house = new Service(code, name, area, cost, maxPeople, rentType, serviceType, standardRoom, description,
                        floors);
                servicesService.createHouse(house);
            case 3:
                Service room = new Service(code, name, area, cost, maxPeople, rentType, serviceType, standardRoom, description);
                servicesService.createRoom(room);
                break;

        }
        request.setAttribute("message", "New service was create");
        request.getRequestDispatcher("service/createService.jsp").forward(request, response);


    }
}
