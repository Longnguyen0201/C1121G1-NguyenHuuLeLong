package repository.impl;

import DTO.ServiceDTO;
import models.service.RentType;
import models.service.Service;
import models.service.ServiceType;
import repository.BaseRepository;
import repository.IServiceRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceRepository implements IServiceRepository {
    BaseRepository baseRepository = new BaseRepository();

    private static final String SQL_SELECT_ALL_SERVICE = "select service_id,service_code,service_name,service_area, " +
            "service_cost,service_max_people,rent_type.rent_type_name,service_type.service_type_name,\n" +
            "standard_room, description_other_convenience,ifnull(pool_area,-1), ifnull(number_of_floors,-1) from service\n" +
            " join rent_type on service.rent_type_id = rent_type.rent_type_id\n" +
            " join service_type on service.service_type_id = service_type.service_type_id\n" +
            "order by service_id;";
    private static final String SQL_CREATE_SERVICE = "insert into service(service_code,service_name,service_area, " +
            "service_cost,service_max_people,rent_type_id,service_type_id,standard_room,description_other_convenience, " +
            "pool_area,number_of_floors) " +
            "value (?,?,?,?,?,?,?,?,?,?,?); ";

    @Override
    public List<ServiceDTO> selectAllService() {
        List<ServiceDTO> list = new ArrayList<>();
        Connection connection = this.baseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_ALL_SERVICE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer id = resultSet.getInt(1);
                String code = resultSet.getString(2);
                String name = resultSet.getString(3);
                Integer area = resultSet.getInt(4);
                Double cost = resultSet.getDouble(5);
                Integer maxPeople = resultSet.getInt(6);
                String rentTypeName = resultSet.getString(7);
                String serviceTypeName = resultSet.getString(8);
                String standardRoom = resultSet.getString(9);
                String description = resultSet.getString(10);
                Double areaPool = resultSet.getDouble(11);
                Integer floors = resultSet.getInt(12);
                list.add(new ServiceDTO(id, code, name, area, cost, maxPeople, rentTypeName, serviceTypeName, standardRoom,
                        description, areaPool, floors));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    @Override
    public List<RentType> getAllRentType() {
        List<RentType> list = new ArrayList<>();
        Connection connection = this.baseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from rent_type;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                list.add(new RentType(id, name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<ServiceType> getAllServiceType() {
        List<ServiceType> list = new ArrayList<>();
        Connection connection = this.baseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from service_type;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                list.add(new ServiceType(id, name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void createVilla(Service villa) {
        Connection connection = this.baseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_CREATE_SERVICE);
            preparedStatement.setString(1, villa.getServiceCode());
            preparedStatement.setString(2, villa.getServiceName());
            preparedStatement.setInt(3, villa.getServiceArea());
            preparedStatement.setDouble(4, villa.getServiceCost());
            preparedStatement.setInt(5, villa.getServiceMaxPeople());
            preparedStatement.setInt(6, villa.getRentTypeId());
            preparedStatement.setInt(7, villa.getServiceTypeId());
            preparedStatement.setString(8, villa.getStandardRoom());
            preparedStatement.setString(9, villa.getDescription());
            preparedStatement.setDouble(10, villa.getAreaPool());
            preparedStatement.setInt(11, villa.getFloors());
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Service selectServiceById(Integer id) {
        Connection connection = this.baseRepository.getConnection();
        Service service = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select *from service where service_id = ?;");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer idService = resultSet.getInt(1);
                String code = resultSet.getString(2);
                String name = resultSet.getString(3);
                Integer area = resultSet.getInt(4);
                Double cost = resultSet.getDouble(5);
                Integer maxPeople = resultSet.getInt(6);
                Integer rentTypeId = resultSet.getInt(7);
                Integer serviceTypeId = resultSet.getInt(8);
                String standardRoom = resultSet.getString(9);
                String description = resultSet.getString(10);
                Double areaPool = resultSet.getDouble(11);
                Integer floors = resultSet.getInt(12);
                service = new Service(idService, code, name, area, cost, maxPeople, rentTypeId, serviceTypeId,
                        standardRoom, description, areaPool, floors);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return service;
    }

    @Override
    public boolean updateService(Service service) {
        boolean rowUpdate = false;
        Connection connection = this.baseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update service set service_code =? , " +
                    "service_name=?,service_area=?,service_cost=?,\n" +
                    "service_max_people=?,rent_type_id=?,service_type_id=?,standard_room=?,\n" +
                    "description_other_convenience=?, pool_area=?,number_of_floors=?\n" +
                    "where service_id = ?;");
            preparedStatement.setString(1, service.getServiceCode());
            preparedStatement.setString(2, service.getServiceName());
            preparedStatement.setInt(3, service.getServiceArea());
            preparedStatement.setDouble(4, service.getServiceCost());
            preparedStatement.setInt(5, service.getServiceMaxPeople());
            preparedStatement.setInt(6, service.getRentTypeId());
            preparedStatement.setInt(7, service.getServiceTypeId());
            preparedStatement.setString(8, service.getStandardRoom());
            preparedStatement.setString(9, service.getDescription());
            preparedStatement.setDouble(10, service.getAreaPool());
            preparedStatement.setInt(11, service.getFloors());
            preparedStatement.setInt(12, service.getServiceId());
            rowUpdate = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return rowUpdate;
    }

    @Override
    public void createHouse(Service house) {
        Connection connection = this.baseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into service(service_code,service_name,service_area," +
                    "service_cost,service_max_people,rent_type_id,service_type_id,standard_room,description_other_convenience," +
                    "number_of_floors)" +
                    "value (?,?,?,?,?,?,?,?,?,?); ");
            preparedStatement.setString(1, house.getServiceCode());
            preparedStatement.setString(2, house.getServiceName());
            preparedStatement.setInt(3, house.getServiceArea());
            preparedStatement.setDouble(4, house.getServiceCost());
            preparedStatement.setInt(5, house.getServiceMaxPeople());
            preparedStatement.setInt(6, house.getRentTypeId());
            preparedStatement.setInt(7, house.getServiceTypeId());
            preparedStatement.setString(8, house.getStandardRoom());
            preparedStatement.setString(9, house.getDescription());
            preparedStatement.setInt(10, house.getFloors());
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createRoom(Service room) {
        Connection connection = this.baseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into service(service_code,service_name,service_area," +
                    "service_cost,service_max_people,rent_type_id,service_type_id,standard_room,description_other_convenience," +
                    "value (?,?,?,?,?,?,?,?,?); ");
            preparedStatement.setString(1, room.getServiceCode());
            preparedStatement.setString(2, room.getServiceName());
            preparedStatement.setInt(3, room.getServiceArea());
            preparedStatement.setDouble(4, room.getServiceCost());
            preparedStatement.setInt(5, room.getServiceMaxPeople());
            preparedStatement.setInt(6, room.getRentTypeId());
            preparedStatement.setInt(7, room.getServiceTypeId());
            preparedStatement.setString(8, room.getStandardRoom());
            preparedStatement.setString(9, room.getDescription());
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean deleteService(Integer id) {
        boolean rowDelete = false;
        Connection connection = this.baseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from service where service_id = ? ;");
            preparedStatement.setInt(1, id);
            rowDelete = preparedStatement.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return rowDelete;
    }
}
