package service.impl;

import DTO.ServiceDTO;
import models.service.RentType;
import models.service.Service;
import models.service.ServiceType;
import repository.IServiceRepository;
import repository.impl.ServiceRepository;
import service.IServicesService;

import java.util.List;

public class ServicesService implements IServicesService {
    IServiceRepository serviceRepository = new ServiceRepository();



    @Override
    public List<ServiceDTO> selectAllService() {
        return serviceRepository.selectAllService();
    }

    @Override
    public List<RentType> getAllRentType() {
        return serviceRepository.getAllRentType();
    }

    @Override
    public List<ServiceType> getAllServiceType() {
        return serviceRepository.getAllServiceType();
    }

    @Override
    public void createVilla(Service villa)  {
  serviceRepository.createVilla(villa);
    }

    @Override
    public Service selectServiceById(Integer id) {
        return serviceRepository.selectServiceById(id);
    }

    @Override
    public boolean updateService(Service service) {
        return serviceRepository.updateService(service);
    }

    @Override
    public void createHouse(Service house) {
        serviceRepository.createHouse(house);
    }

    @Override
    public void createRoom(Service room) {
        serviceRepository.createRoom(room);
    }

    @Override
    public boolean deleteService(Integer id) {
        return serviceRepository.deleteService(id);
    }
}
