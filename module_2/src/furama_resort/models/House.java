package furama_resort.models;

public class House extends Facility {
    private String typeRoom;
    private int numberFloor;

    public House() {
    }

    public House(String typeRoom, int numberFloor) {
        this.typeRoom = typeRoom;
        this.numberFloor = numberFloor;
    }

    public House(String idService, String nameService, double useArea, double price, int maxPeople, String rentalType, String typeRoom, int numberFloor ) {
        super(idService, nameService, useArea, price, maxPeople, rentalType);
        this.typeRoom = typeRoom;
        this.numberFloor = numberFloor;
    }

    public String getTypeRoom() {
        return typeRoom;
    }

    public void setTypeRoom(String typeRoom) {
        this.typeRoom = typeRoom;
    }

    public int getNumberFloor() {
        return numberFloor;
    }

    public void setNumberFloor(int numberFloor) {
        this.numberFloor = numberFloor;
    }

    @Override
    public String toString() {
        return "House{" + "idService = " + getIdFacility() +
                ", serviceName = " + getNameService() +
                ", usableArea = " + getUseArea() +
                ", price = " + getPrice() +
                ", maximumPerson = " + getMaxPeople() +
                ", rentType = " + getRentalType() +
                ", houseType = " + typeRoom +
                ", houseNumberFloor = " + numberFloor +
                '}';
    }

    @Override
    public String writeToFile() {
        return super.writeToFile() + ',' + typeRoom + ',' + numberFloor;
    }
}
