package vehicleManagement.model;

import java.util.ArrayList;

public class Brand {
    private String ID;
    private String brandName;
    private String country;

    public Brand(String ID, String brandName, String country) {
        this.ID = ID;
        this.brandName = brandName;
        this.country = country;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "ID='" + ID + '\'' +
                ", Tên hãng='" + brandName + '\'' +
                ", Quốc gia ='" + country + '\'';
    }
}
