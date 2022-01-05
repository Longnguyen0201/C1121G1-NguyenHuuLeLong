package ss4_lop_va_doi_tuong_trong_java.bai_tap;

public class Fan {
    private final int SLOW = 1;
    private final int MEDIUM = 2;
    private final int FAST = 3;
    private int speed;
    private boolean on;
    private double radius;
    private String color;

    public Fan() {
        this.speed = SLOW;
        this.on = false;
        this.radius = 5;
        this.color = "Blue";
    }

    public Fan(int speed, boolean status, double radius, String color) {
        this.speed=speed;
        this.on=status;
        this.radius=radius;
        this.color=color;
    }

    public void setSpeed(int speed) {
        if (speed == this.FAST) {
            this.speed = this.FAST;
        } else if (speed == this.MEDIUM) {
            this.speed = this.MEDIUM;
        } else {
            this.speed = this.SLOW;
        }
    }

    public void setStatus(boolean status) {
       this.on =status;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public String getSpeed() {
        if(this.speed == this.SLOW){
            return "Slow";
        }else if (this.speed==this.MEDIUM){
            return "Medium";
        }else {
            return "Fast";
        }
    }
    public String getStatus(){
        if (this.on){
            return "fan is on";
        }else {
            return "fan is off";
        }
    }
    public double getRadius(){
        return this.radius;
    }
    public String getColor(){
        return this.color;
    }
    public String toString(){
        return "Speed: "+ getSpeed()+", radius: "+getRadius()+", color: "+getColor()+", status: "+ getStatus();
    }

    public static void main(String[] args) {
        Fan fan=new Fan();
        Fan fan1=new Fan(3,true,10,"Yellow");
        Fan fan2=new Fan(2,false,5,"Blue");
        System.out.println("Fan: "+ fan);
        System.out.println("Fan 1: "+ fan1);
        System.out.println("Fan 2: "+ fan2 );
    }
}
