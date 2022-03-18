package repository.impl;

import DTO.EmployeeDTO;
import models.Division;
import models.EducationDegree;
import models.Employee;
import models.Position;
import repository.BaseRepository;
import repository.IEmployeeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements IEmployeeRepository {
    BaseRepository baseRepository = new BaseRepository();
    private static final String SQL_SELECT_ALL_EMPLOYEE ="select employee_id,employee_name,employee_birthday,employee_id_card,employee_salary,employee_phone,employee_email,employee_address,position.position_name,education_degree.education_degree_name,division.division_name\n" +
            "from employee\n" +
            "join position on employee.position_id = position.position_id\n" +
            "join education_degree on employee.education_degree_id = education_degree.education_degree_id\n" +
            "join division on employee.division_id = division.division_id\n" +
            "order by employee_id;";

    @Override
    public List<EmployeeDTO> selectAllEmployee() {
        List<EmployeeDTO> employeeList = new ArrayList<>();
        Connection connection = this.baseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_ALL_EMPLOYEE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Integer id = resultSet.getInt("employee_id");
                String name = resultSet.getString("employee_name");
                String birthday = resultSet.getString("employee_birthday");
                String idCard = resultSet.getString("employee_id_card");
                Double salary = resultSet.getDouble("employee_salary");
                String phone = resultSet.getString("employee_phone");
                String email = resultSet.getString("employee_email");
                String address = resultSet.getString("employee_address");
                String positionName = resultSet.getString("position_name");
                String educationDegreeName = resultSet.getString("education_degree_name");
                String divisionName = resultSet.getString("division_name");
                employeeList.add(new EmployeeDTO(id,name,birthday,idCard,salary,phone,email,address,positionName,educationDegreeName,divisionName));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return employeeList;
    }

    @Override
    public List<Position> getAllPosition() {
        List<Position> positionList = new ArrayList<>();
        Connection connection = baseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM position;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                positionList.add(new Position(resultSet.getInt("position_id"),resultSet.getString("position_name")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return positionList;
    }

    @Override
    public List<EducationDegree> getAllEducation() {
        List<EducationDegree> educationDegreeList = new ArrayList<>();
        Connection connection = baseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM education_degree;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                educationDegreeList.add(new EducationDegree(resultSet.getInt("education_degree_id"),resultSet.getString("education_degree_name")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return educationDegreeList;
    }

    @Override
    public List<Division> getAllDivision() {
        List<Division> divisionList = new ArrayList<>();
        Connection connection = baseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM division;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                divisionList.add(new Division(resultSet.getInt("division_id"),resultSet.getString("division_name")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return divisionList;
    }

}
