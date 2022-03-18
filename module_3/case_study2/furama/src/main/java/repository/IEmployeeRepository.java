package repository;

import DTO.EmployeeDTO;
import models.Division;
import models.EducationDegree;
import models.Employee;
import models.Position;

import java.util.List;

public interface IEmployeeRepository {
    List<EmployeeDTO> selectAllEmployee();

    List<Position> getAllPosition();

    List<EducationDegree> getAllEducation();

    List<Division> getAllDivision();
}
