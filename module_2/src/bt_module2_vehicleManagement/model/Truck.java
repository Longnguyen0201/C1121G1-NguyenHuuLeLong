package vehicleManagement.model;

public class Truck extends vehicleManagement.model.Vehicle {
    private  int tonnage;

    public Truck(String numberPlate, String nameBrand, int yearManufacture, String owner,int tonnage) {
        super(numberPlate, nameBrand, yearManufacture, owner);
        this.tonnage = tonnage;
    }


    public int getTonnage() {
        return tonnage;
    }

    public void setTonnage(int tonnage) {
        this.tonnage = tonnage;
    }

    @Override
    public String toString() {
        return super.toString()+
                ", Tải trọng: " + tonnage;
    }
}
