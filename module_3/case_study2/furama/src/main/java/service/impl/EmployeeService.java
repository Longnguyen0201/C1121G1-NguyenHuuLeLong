package service.impl;

import DTO.EmployeeDTO;
import models.employee.Division;
import models.employee.EducationDegree;
import models.employee.Employee;
import models.employee.Position;
import repository.impl.EmployeeRepository;
import service.IEmployeeService;

import java.util.List;

public class EmployeeService implements IEmployeeService {
    EmployeeRepository employeeRepository = new EmployeeRepository();
    @Override
    public List<EmployeeDTO> selectAllEmployee() {
        return employeeRepository.selectAllEmployee();
    }

    @Override
    public List<Position> getAllPosition() {
        return employeeRepository.getAllPosition();
    }

    @Override
    public List<EducationDegree> getAllEducation() {
        return employeeRepository.getAllEducation();
    }

    @Override
    public List<Division> getAllDivision() {
        return employeeRepository.getAllDivision();
    }

    @Override
    public void createEmployee(Employee employee) {
        employeeRepository.createEmployee(employee);
    }

    @Override
    public Employee selectEmployeeById(Integer id) {
        return employeeRepository.selectEmployeeById(id);
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        return employeeRepository.updateEmployee(employee);
    }

    @Override
    public boolean deleteEmployee(Integer id) {
        return employeeRepository.deleteEmployee(id);
    }

    @Override
    public List<EmployeeDTO> searchEmployeeByName(String search) {
        return employeeRepository.searchEmployeeByName(search);
    }
}
