package ss4_lop_va_doi_tuong_trong_java.ly_thuyet.StudentManager;

public class Student {
    int id;
    String name;
    String address;
    String birthday;
    String className;
    String School;
    int point =10;
    public  Student(){

    }

    public Student(int id, String name, String birthday, String address, String className, String school){
        this.id=id;
        this.name= name;
        this.birthday=birthday;
        this.address =address;
        this.className=className;
        this.School=school;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setSchool(String school) {
        School = school;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getClassName() {
        return className;
    }

    public String getSchool() {
        return School;
    }

    public int getPoint() {
        return point;
    }
    public void study(String subject){
        System.out.println(this.name+ " study " + subject);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", birthday='" + birthday + '\'' +
                ", className='" + className + '\'' +
                ", School='" + School + '\'' +
                '}';
    }
}
