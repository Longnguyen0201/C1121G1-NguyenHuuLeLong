package furama_resort.models;


public class Employee extends Person {
    private String level;
    private String position;
    private int salary;

    public Employee() {
    }


    public Employee(int code, String name, String birthday, String gender, String idNumber, String phoneNumber, String email, String level, String position, int salary) {
        super(code, name, birthday, gender, idNumber, phoneNumber, email);
        this.level = level;
        this.position = position;
        this.salary = salary;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }


    @Override
    public String toString() {
        return super.toString() +
                ", level = " + level +
                ", position = " + position +
                ", salary= " + salary;
    }

    public String writeToFile() {
        return super.getCode() +
                "," + super.getName() +
                "," + super.getBirthday() +
                "," + super.getGender() +
                "," + super.getIdNumber() +
                "," + super.getPhoneNumber() +
                "," + super.getEmail() +
                "," + level +
                "," + position +
                "," + salary;
    }

}
