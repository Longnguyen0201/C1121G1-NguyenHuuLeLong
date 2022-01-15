package vehicleManagement.model;

public class Car extends Vehicle {
    private int seats;
    private String carType;

    public Car(String numberPlate, String nameBrand, int yearManufacture,String carType, String owner, int seats) {
        super(numberPlate, nameBrand, yearManufacture, owner);
        this.seats = seats;
        this.carType = carType;
    }


    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }
}
