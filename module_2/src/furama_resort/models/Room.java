package furama_resort.models;

public class Room extends Facility{
    private String freeService;

    public Room() {
    }

    public Room(String idService,String nameService, double useArea, double price, int maxPeople, String rentalType, String freeService) {
        super(idService,nameService, useArea, price, maxPeople, rentalType);
        this.freeService = freeService;
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    @Override
    public String toString() {
        return "Room{" + "idService = " + getIdFacility()+
                ", serviceName = " + getNameService() +
                ", usableArea = " + getUseArea() +
                ", price = " + getPrice() +
                ", maximumPerson = " + getMaxPeople() +
                ", rentType = " + getRentalType() +
                ", freeService='" + freeService + '\'' +
                '}';
    }

    @Override
    public String writeToFile() {
        return super.writeToFile()+','+freeService;
    }
}
