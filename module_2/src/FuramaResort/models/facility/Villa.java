package FuramaResort.models.facility;

import FuramaResort.models.facility.House;

public class Villa extends House {
    private int poolArea;

    public Villa() {
    }

    public Villa(String nameSerice, float useArea, float rentalCosts, int maxPeople, String rentalType, int numberUse, String roomStandard, int floorNumber, int poolArea) {
        super(nameSerice, useArea, rentalCosts, maxPeople, rentalType, numberUse, roomStandard, floorNumber);
        this.poolArea = poolArea;
    }

    public int getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(int poolArea) {
        this.poolArea = poolArea;
    }
}


