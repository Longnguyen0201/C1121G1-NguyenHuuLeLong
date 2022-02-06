package vehicleManagement.model;

public class Motorcycle extends vehicleManagement.model.Vehicle {
    private int capacity;

    public Motorcycle(String numberPlate, String nameBrand, int yearManufacture, String owner, int capacity) {
        super(numberPlate, nameBrand, yearManufacture, owner);
        this.capacity =capacity;
    }


    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
