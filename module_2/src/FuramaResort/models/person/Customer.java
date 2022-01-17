package FuramaResort.models.person;

import FuramaResort.models.person.Person;

public class Customer extends Person {
    private  String typeCustomer;
    private  String address;

    public Customer() {
    }

    public Customer(String code, String name, String birthday, String gender, String idNumber, String phoneNumber, String email, String typeCustomer, String address) {
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
}
