package FuramaResort.models.facility;

import FuramaResort.models.facility.Facility;

public class Room extends Facility {
    private String freeService;

    public Room() {
    }

    public Room(String nameSerice, float useArea, float rentalCosts, int maxPeople, String rentalType, int numberUse, String freeService) {
        super(nameSerice, useArea, rentalCosts, maxPeople, rentalType, numberUse);
        this.freeService = freeService;
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }
}
