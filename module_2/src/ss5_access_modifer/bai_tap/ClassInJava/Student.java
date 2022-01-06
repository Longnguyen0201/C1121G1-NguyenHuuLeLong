package ss5_access_modifer.bai_tap.ClassInJava;

public class Student {
    private String name ="John";
    private String classes="C02";

    Student(){

    }

    void setName(String name) {
        this.name = name;
    }

    protected void setClasses(String classes) {
        this.classes = classes;
    }

    public String getName() {
        return name;
    }

    public String getClasses() {
        return classes;
    }
}
