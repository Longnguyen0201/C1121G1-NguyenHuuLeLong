package service;

import DTO.EmployeeDTO;
import models.employee.Division;
import models.employee.EducationDegree;
import models.employee.Employee;
import models.employee.Position;

import java.util.List;
import java.util.Map;

public interface IEmployeeService {
    List<EmployeeDTO> selectAllEmployee();

    List<Position> getAllPosition();

    List<EducationDegree> getAllEducation();

    List<Division> getAllDivision();

    Map<String, String> createEmployee(Employee employee);

    Employee selectEmployeeById(Integer id);

    boolean updateEmployee(Employee employee);

    boolean deleteEmployee(Integer id);

    List<EmployeeDTO> searchEmployeeByName(String search);
}
