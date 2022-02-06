package furama_resort.models;

public class Customer extends Person {
    private String typeCustomer;
    private String address;

    public Customer() {
    }

    public Customer(int code, String name, String birthday, String gender, String idNumber, String phoneNumber, String email, String typeCustomer, String address) {
        super(code, name, birthday, gender, idNumber, phoneNumber, email);
        this.typeCustomer = typeCustomer;
        this.address = address;
    }

    public String getTypeCustomer() {
        return typeCustomer;
    }

    public void setTypeCustomer(String typeCustomer) {
        this.typeCustomer = typeCustomer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    @Override
    public String toString() {
        return super.toString() +
                ", typeCustomer='" + typeCustomer + '\'' +
                ", address='" + address + '\'';
    }

    public String writeToFile() {
        return  super.getCode()+
                ", " +super.getName() +
                "," + super.getBirthday() +
                "," + super.getGender() +
                "," + super.getIdNumber() +
                "," + super.getPhoneNumber() +
                "," + super.getEmail() +
                "," + typeCustomer +
                "," + address;
    }
}
