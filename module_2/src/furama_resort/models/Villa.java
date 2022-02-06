package furama_resort.models;

public class Villa extends Facility {
    private String typeRoom;
    private int poolArea;
    private int numberFloor;

    public Villa(){

    }
    public Villa(String typeRoom, int poolArea, int numberFloor) {
        this.typeRoom = typeRoom;
        this.poolArea = poolArea;
        this.numberFloor = numberFloor;
    }

    public Villa(String idService, String nameService, double useArea, double price, int maxPeople, String rentalType, String typeRoom, int poolArea, int numberFloor) {
        super(idService, nameService, useArea, price, maxPeople, rentalType);
        this.typeRoom = typeRoom;
        this.poolArea = poolArea;
        this.numberFloor = numberFloor;
    }


    public String getTypeRoom() {
        return typeRoom;
    }

    public void setTypeRoom(String typeRoom) {
        this.typeRoom = typeRoom;
    }

    public int getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(int poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberFloor() {
        return numberFloor;
    }

    public void setNumberFloor(int numberFloor) {
        this.numberFloor = numberFloor;
    }

    @Override
    public String toString() {
        return "Villa{" + "IdService = " + getIdFacility() +
                ", serviceName = " + getNameService() +
                ", usableArea = " + getUseArea() +
                ", price = " + getPrice() +
                ", maximumPerson = " + getMaxPeople() +
                ", rentType = " + getRentalType() +
                ", villaType = " + typeRoom +
                ", villaPoolArea = " + poolArea +
                ", villaNumberFloor = " + numberFloor +
                '}';
    }

    @Override
    public String writeToFile() {
        return super.writeToFile() + ',' + typeRoom + ',' + poolArea + ',' + numberFloor;
    }
}
