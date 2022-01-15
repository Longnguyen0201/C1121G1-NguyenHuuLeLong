package vehicleManagement.model;

public abstract class Vehicle {
    private String numberPlate;
    private String nameBrand;
    private int yearManufacture;
    private String owner;

    public Vehicle(String numberPlate, String nameBrand, int yearManufacture, String owner) {
        this.numberPlate = numberPlate;
        this.nameBrand = nameBrand;
        this.yearManufacture = yearManufacture;
        this.owner = owner;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public String getNameBrand() {
        return nameBrand;
    }

    public void setNameBrand(String nameBrand) {
        this.nameBrand = nameBrand;
    }

    public int getYearManufacture() {
        return yearManufacture;
    }

    public void setYearManufacture(int yearManufacture) {
        this.yearManufacture = yearManufacture;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Biển kiểm soát: " + numberPlate + '\'' +
                ", Hãng sản xuất: " + nameBrand + '\'' +
                ", Năm sản xuất: " + yearManufacture +
                ", Chủ sở hữu: " + owner + '\'';
    }
}