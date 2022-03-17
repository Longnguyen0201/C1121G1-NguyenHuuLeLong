package models;

public class Customer {
    private int id;
    private String code;
    private String name;
    private String birthday;
    private int gender;
    private String idCard;
    private String phone;
    private String email;
    private String address;
    private int customerType;
    private String customerTypeName;

    public Customer() {
    }

    public Customer(String code, String name, String birthday, int gender, String idCard, String phone,
                    String email, String address, String customerTypeName) {
        this.code = code;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.idCard = idCard;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.customerTypeName = customerTypeName;
    }

    public Customer(String code, String name, String birthday, int gender, String idCard, String phone, String email, String address, int customerType) {
        this.code = code;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.idCard = idCard;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.customerType = customerType;
    }

    public Customer(String code, String name, String birthday, int gender, String idCard, String phone,
                    String email, String address, int customerType, String customerTypeName) {
        this.code = code;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.idCard = idCard;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.customerType = customerType;
        this.customerTypeName = customerTypeName;
    }

    public Customer(int id, String code, String name, String birthday, int gender, String idCard, String phone,
                    String email, String address, int customerType, String customerTypeName) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.idCard = idCard;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.customerType = customerType;
        this.customerTypeName = customerTypeName;
    }

    public Customer(int id, String code, String name, String birthday, int gender, String idCard, String phone,
                    String email, String address, String customerTypeName) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.idCard = idCard;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.customerTypeName = customerTypeName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCustomerType() {
        return customerType;
    }

    public void setCustomerType(int customerType) {
        this.customerType = customerType;
    }

    public String getCustomerTypeName() {
        return customerTypeName;
    }

    public void setCustomerTypeName(String customerTypeName) {
        this.customerTypeName = customerTypeName;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", birthday='" + birthday + '\'' +
                ", gender=" + gender +
                ", idCard='" + idCard + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", customerType=" + customerType +
                ", customerTypeName='" + customerTypeName + '\'' +
                '}';
    }
}
