package service.impl;

import DTO.EmployeeDTO;
import models.employee.Division;
import models.employee.EducationDegree;
import models.employee.Employee;
import models.employee.Position;
import repository.impl.EmployeeRepository;
import service.IEmployeeService;
import service.Regex;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeService implements IEmployeeService {
    EmployeeRepository employeeRepository = new EmployeeRepository();
    Regex regex = new Regex();


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
    public Map<String, String> createEmployee(Employee employee) {
        Map<String, String> map = new HashMap<>();
        boolean flag = true;
        if (employee.getName().equals("")) {
            flag = false;
            map.put("name", "Không được để trống");
        }
        if (!employee.getName().matches(regex.REGEX_NAME)) {
            flag = false;
            map.put("name", "Không đúng định dạng viết hoa kí tự đầu,có dấu(ví dụ:Nguyễn Long");
        }
//        if (!employee.getBirthday().matches(regex.REGEX_DATE)) {
//            flag = false;
//            map.put("birthday", "Không đúng định dạng yyyy-mm-dd (ví dụ:2021-12-02");
//        }
        if (!employee.getIdCard().matches(regex.REGEX_NUMBER)) {
            flag = false;
            map.put("idCard", "Không đúng định dạng số");
        }
        if (employee.getSalary() < 0) {
            flag = false;
            map.put("salary", "Lương phải lớn hơn 0");
        }
        if (!employee.getPhone().matches(regex.REGEX_PHONE)) {
            flag = false;
            map.put("phone", "Sai định dạng số điện thoại (090|091|(84)+");

        }
        if (!employee.getEmail().matches(regex.REGEX_EMAIL)) {
            flag = false;
            map.put("email", "Sai định dạng email (ví dụ: test@gmail.com)");
        }
        if (flag) {
            employeeRepository.createEmployee(employee);
        }
        return map;
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
