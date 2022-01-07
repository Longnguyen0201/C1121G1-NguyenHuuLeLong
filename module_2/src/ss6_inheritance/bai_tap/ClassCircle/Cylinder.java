package ss6_inheritance.bai_tap.ClassCircle;

public class Cylinder extends Circle{
    private double high;

    public Cylinder(){
    }
    public Cylinder(double radius,String color,double high){
        super(radius, color);
        this.high = high;
    }

    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }
    public double getVolumetric(){
        return getArea()*high;
    }

    @Override
    public String toString() {
        return "Cylinder{" +super.toString()+
                "high=" + high + " Volumetric: " + getVolumetric() +
                '}';
    }
}
