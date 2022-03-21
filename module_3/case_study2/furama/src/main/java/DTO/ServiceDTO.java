package DTO;

public class ServiceDTO {
    private Integer serviceId;
    private String serviceCode;
    private String serviceName;
    private Integer serviceArea;
    private Double serviceCost;
    private Integer serviceMaxPeople;
    private String rentTypeName;
    private String serviceTypeName;
    private String standardRoom;
    private String description;
    private Double areaPool;
    private Integer floors;

    public ServiceDTO() {
    }

    public ServiceDTO(Integer serviceId, String serviceCode, String serviceName, Integer serviceArea,
                      Double serviceCost, Integer serviceMaxPeople, String rentTypeName, String serviceTypeName,
                      String standardRoom, String description, Double areaPool, Integer floors) {
        this.serviceId = serviceId;
        this.serviceCode = serviceCode;
        this.serviceName = serviceName;
        this.serviceArea = serviceArea;
        this.serviceCost = serviceCost;
        this.serviceMaxPeople = serviceMaxPeople;
        this.rentTypeName = rentTypeName;
        this.serviceTypeName = serviceTypeName;
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

    public String getRentTypeName() {
        return rentTypeName;
    }

    public void setRentTypeName(String rentTypeName) {
        this.rentTypeName = rentTypeName;
    }

    public String getServiceTypeName() {
        return serviceTypeName;
    }

    public void setServiceTypeName(String serviceTypeName) {
        this.serviceTypeName = serviceTypeName;
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

    @Override
    public String toString() {
        return "ServiceDTO{" +
                "serviceId=" + serviceId +
                ", serviceCode='" + serviceCode + '\'' +
                ", serviceName='" + serviceName + '\'' +
                ", serviceArea=" + serviceArea +
                ", serviceCost=" + serviceCost +
                ", serviceMaxPeople=" + serviceMaxPeople +
                ", rentTypeName='" + rentTypeName + '\'' +
                ", serviceTypeName='" + serviceTypeName + '\'' +
                ", standardRoom='" + standardRoom + '\'' +
                ", description='" + description + '\'' +
                ", areaPool=" + areaPool +
                ", floors=" + floors +
                '}';
    }
}
