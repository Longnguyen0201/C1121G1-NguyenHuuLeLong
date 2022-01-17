package FuramaResort.models.facility;

import FuramaResort.models.facility.Facility;

public class House extends Facility {
    private String roomStandard;
    private  int floorNumber;

    public House() {
    }

    public House(String nameSerice, float useArea, float rentalCosts, int maxPeople, String rentalType, int numberUse, String roomStandard, int floorNumber) {
        super(nameSerice, useArea, rentalCosts, maxPeople, rentalType, numberUse);
        this.roomStandard = roomStandard;
        this.floorNumber = floorNumber;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }
}
