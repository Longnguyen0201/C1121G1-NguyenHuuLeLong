package FuramaResort.models;

public class Contract {
    private int idContract;
    private String codeBooking;
    private int deposit ;
    private int totalPay;
    private String codeCustomer;

    public Contract() {
    }

    public Contract(int idContract, String codeBooking, int deposit, int totalPay, String codeCustomer) {
        this.idContract = idContract;
        this.codeBooking = codeBooking;
        this.deposit = deposit;
        this.totalPay = totalPay;
        this.codeCustomer = codeCustomer;
    }

    public int getIdContract() {
        return idContract;
    }

    public void setIdContract(int idContract) {
        this.idContract = idContract;
    }

    public String getCodeBooking() {
        return codeBooking;
    }

    public void setCodeBooking(String codeBooking) {
        this.codeBooking = codeBooking;
    }

    public int getDeposit() {
        return deposit;
    }

    public void setDeposit(int deposit) {
        this.deposit = deposit;
    }

    public int getTotalPay() {
        return totalPay;
    }

    public void setTotalPay(int totalPay) {
        this.totalPay = totalPay;
    }

    public String getCodeCustomer() {
        return codeCustomer;
    }

    public void setCodeCustomer(String codeCustomer) {
        this.codeCustomer = codeCustomer;
    }
}
