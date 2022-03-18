package service.impl;

import DTO.EmployeeDTO;
import models.Division;
import models.EducationDegree;
import models.Employee;
import models.Position;
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
}
