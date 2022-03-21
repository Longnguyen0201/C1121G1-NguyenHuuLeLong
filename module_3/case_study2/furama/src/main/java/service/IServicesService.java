package service;

import DTO.ServiceDTO;
import models.service.RentType;
import models.service.Service;
import models.service.ServiceType;

import java.sql.SQLException;
import java.util.List;

public interface IServicesService {
    List<ServiceDTO> selectAllService();

    List<RentType> getAllRentType();

    List<ServiceType> getAllServiceType();

    void createVilla(Service service) ;

    Service selectServiceById(Integer id);

    boolean updateService(Service service);

    void createHouse(Service house);

    void createRoom(Service room);

    boolean deleteService(Integer id);
}
