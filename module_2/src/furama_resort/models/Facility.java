package furama_resort.models;

public abstract class Facility {
    private int value = 0;
    private String idFacility;
    private String nameService;
    private double useArea;
    private double price;
    private int maxPeople;
    private  String rentalType;

    public Facility() {
    }

    public Facility(String idFacility,String nameService, double useArea, double price, int maxPeople, String rentalType) {
        this.idFacility = idFacility;
        this.nameService = nameService;
        this.useArea = useArea;
        this.price = price;
        this.maxPeople = maxPeople;
        this.rentalType = rentalType;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getIdFacility() {
        return idFacility;
    }

    public void setIdFacility(String idFacility) {
        this.idFacility = idFacility;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public double getUseArea() {
        return useArea;
    }

    public void setUseArea(double useArea) {
        this.useArea = useArea;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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

    @Override
    public String toString() {
        return "Facility{" +
                "ID = '" + idFacility +"\'" +
                "nameService='" + nameService + '\'' +
                ", useArea=" + useArea +
                ", price=" + price +
                ", maxPeople=" + maxPeople +
                ", rentalType='" + rentalType + '\'' +
                '}';
    }
    public String writeToFile(){
        return idFacility +
                ',' + nameService +
                ',' + useArea +
                ',' + price +
                ',' + maxPeople +
                ',' + rentalType;
    }

}
