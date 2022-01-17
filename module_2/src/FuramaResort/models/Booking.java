package FuramaResort.models;

public class Booking {
    private String codeBooking;
    private String dayStart;
    private String dayEnd;
    private String codeCustomer;
    private String nameService;
    private String typeServiec;

    public Booking() {
    }

    public Booking(String codeBooking, String dayStart, String dayEnd, String codeCustomer, String nameService, String typeServiec) {
        this.codeBooking = codeBooking;
        this.dayStart = dayStart;
        this.dayEnd = dayEnd;
        this.codeCustomer = codeCustomer;
        this.nameService = nameService;
        this.typeServiec = typeServiec;
    }

    public String getCodeBooking() {
        return codeBooking;
    }

    public void setCodeBooking(String codeBooking) {
        this.codeBooking = codeBooking;
    }

    public String getDayStart() {
        return dayStart;
    }

    public void setDayStart(String dayStart) {
        this.dayStart = dayStart;
    }

    public String getDayEnd() {
        return dayEnd;
    }

    public void setDayEnd(String dayEnd) {
        this.dayEnd = dayEnd;
    }

    public String getCodeCustomer() {
        return codeCustomer;
    }

    public void setCodeCustomer(String codeCustomer) {
        this.codeCustomer = codeCustomer;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public String getTypeServiec() {
        return typeServiec;
    }

    public void setTypeServiec(String typeServiec) {
        this.typeServiec = typeServiec;
    }
}
