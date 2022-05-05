package repository.impl;

import DTO.ContractDTO;
import models.contract.Contract;
import repository.BaseRepository;
import repository.IContractRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContractRepository implements IContractRepository {
    BaseRepository baseRepository = new BaseRepository();
    private static final  String SQL_CONTRACT_LIST = "select contract_id, contract_start_date,contract_end_date,contract_deposit, contract_total_money,employee.employee_name,\n" +
            "customer.customer_name,service.service_name from contract\n" +
            "join employee on employee.employee_id = contract.employee_id\n" +
            "join customer on customer.customer_id = contract.customer_id\n" +
            "join service on service.service_id = contract.service_id\n" +
            "order by contract_id;";
    private static final String SQL_CREATE_CONTRACT = "insert into contract(contract_start_date," +
            "contract_end_date,contract_deposit,contract_total_money,employee_id,customer_id,service_id)\n" +
            "value (?,?,?,?,?,?,?);\n";

    @Override
    public List<ContractDTO> contractList() {
        List<ContractDTO> contractDTOList = new ArrayList<>();
        Connection connection = this.baseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_CONTRACT_LIST);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Integer id = resultSet.getInt(1);
                String startDate = resultSet.getString(2);
                String endDate = resultSet.getString(3);
                Double deposit = resultSet.getDouble(4);
                Double total = resultSet.getDouble(5);
                String employeeName = resultSet.getString(6);
                String customerName = resultSet.getString(7);
                String serviceName = resultSet.getString(8);
                contractDTOList.add(new ContractDTO(id,startDate,endDate,deposit,total,employeeName,
                        customerName,serviceName));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contractDTOList;
    }

    @Override
    public void createContract(Contract contract) {
        Connection connection = this.baseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_CREATE_CONTRACT);
            preparedStatement.setString(1,contract.getStartDate());
            preparedStatement.setString(2,contract.getEndDate());
            preparedStatement.setDouble(3,contract.getDeposit());
            preparedStatement.setDouble(4,contract.getTotalMoney());
            preparedStatement.setInt(5,contract.getEmployeeId());
            preparedStatement.setInt(6,contract.getCustomerId());
            preparedStatement.setInt(7,contract.getServiceId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
