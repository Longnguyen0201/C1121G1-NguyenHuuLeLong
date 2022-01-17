package FuramaResort.models.facility;

public abstract class Facility {
    private String nameSerice;
    private float useArea;
    private float rentalCosts;
    private int maxPeople;
    private String rentalType;
    private  int numberUse = 0;

    public Facility() {
    }

    public Facility(String nameSerice, float useArea, float rentalCosts, int maxPeople, String rentalType, int numberUse) {
        this.nameSerice = nameSerice;
        this.useArea = useArea;
        this.rentalCosts = rentalCosts;
        this.maxPeople = maxPeople;
        this.rentalType = rentalType;
        this.numberUse = numberUse;
    }

    public String getNameSerice() {
        return nameSerice;
    }

    public void setNameSerice(String nameSerice) {
        this.nameSerice = nameSerice;
    }

    public float getUseArea() {
        return useArea;
    }

    public void setUseArea(float useArea) {
        this.useArea = useArea;
    }

    public float getRentalCosts() {
        return rentalCosts;
    }

    public void setRentalCosts(float rentalCosts) {
        this.rentalCosts = rentalCosts;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getRentalType() {
        return rentalType;
    }

    public void setRentalType(String rentalType) {
        this.rentalType = rentalType;
    }

    public int getNumberUse() {
        return numberUse;
    }

    public void setNumberUse(int numberUse) {
        this.numberUse = numberUse;
    }
}
