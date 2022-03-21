package models.service;

public class Service {
    private Integer serviceId;
    private String serviceCode;
    private String serviceName;
    private Integer serviceArea;
    private Double serviceCost;
    private Integer serviceMaxPeople;
    private Integer rentTypeId;
    private Integer serviceTypeId;
    private String standardRoom;
    private String description;
    private Double areaPool;
    private Integer floors;

    public Service(String serviceCode, String serviceName, Integer serviceArea, Double serviceCost,
                   Integer serviceMaxPeople, Integer rentTypeId, Integer serviceTypeId, String standardRoom,
                   String description, Integer floors) {
        this.serviceCode = serviceCode;
        this.serviceName = serviceName;
        this.serviceArea = serviceArea;
        this.serviceCost = serviceCost;
        this.serviceMaxPeople = serviceMaxPeople;
        this.rentTypeId = rentTypeId;
        this.serviceTypeId = serviceTypeId;
        this.standardRoom = standardRoom;
        this.description = description;
        this.floors = floors;
    }

    public Service(String serviceCode, String serviceName, Integer serviceArea, Double serviceCost,
                   Integer serviceMaxPeople, Integer rentTypeId, Integer serviceTypeId, String standardRoom,
                   String description) {
        this.serviceCode = serviceCode;
        this.serviceName = serviceName;
        this.serviceArea = serviceArea;
        this.serviceCost = serviceCost;
        this.serviceMaxPeople = serviceMaxPeople;
        this.rentTypeId = rentTypeId;
        this.serviceTypeId = serviceTypeId;
        this.standardRoom = standardRoom;
        this.description = description;
    }

    public Service(Integer serviceId, String serviceCode, String serviceName, Integer serviceArea,
                   Double serviceCost, Integer serviceMaxPeople, Integer rentTypeId, Integer serviceTypeId,
                   String standardRoom, String description, Double areaPool, Integer floors) {
        this.serviceId = serviceId;
        this.serviceCode = serviceCode;
        this.serviceName = serviceName;
        this.serviceArea = serviceArea;
        this.serviceCost = serviceCost;
        this.serviceMaxPeople = serviceMaxPeople;
        this.rentTypeId = rentTypeId;
        this.serviceTypeId = serviceTypeId;
        this.standardRoom = standardRoom;
        this.description = description;
        this.areaPool = areaPool;
        this.floors = floors;
    }

    public Service(String serviceCode, String serviceName, Integer serviceArea, Double serviceCost,
                   Integer serviceMaxPeople, Integer rentTypeId, Integer serviceTypeId, String standardRoom,
                   String description, Double areaPool, Integer floors) {
        this.serviceCode = serviceCode;
        this.serviceName = serviceName;
        this.serviceArea = serviceArea;
        this.serviceCost = serviceCost;
        this.serviceMaxPeople = serviceMaxPeople;
        this.rentTypeId = rentTypeId;
        this.serviceTypeId = serviceTypeId;
        this.standardRoom = standardRoom;
        this.description = description;
        this.areaPool = areaPool;
        this.floors = floors;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Integer getServiceArea() {
        return serviceArea;
    }

    public void setServiceArea(Integer serviceArea) {
        this.serviceArea = serviceArea;
    }

    public Double getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(Double serviceCost) {
        this.serviceCost = serviceCost;
    }

    public Integer getServiceMaxPeople() {
        return serviceMaxPeople;
    }

    public void setServiceMaxPeople(Integer serviceMaxPeople) {
        this.serviceMaxPeople = serviceMaxPeople;
    }

    public Integer getRentTypeId() {
        return rentTypeId;
    }

    public void setRentTypeId(Integer rentTypeId) {
        this.rentTypeId = rentTypeId;
    }

    public Integer getServiceTypeId() {
        return serviceTypeId;
    }

    public void setServiceTypeId(Integer serviceTypeId) {
        this.serviceTypeId = serviceTypeId;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getAreaPool() {
        return areaPool;
    }

    public void setAreaPool(Double areaPool) {
        this.areaPool = areaPool;
    }

    public Integer getFloors() {
        return floors;
    }

    public void setFloors(Integer floors) {
        this.floors = floors;
    }
}
