package ss6_inheritance.ly_thuyet.test1;

public class CircleFromSimpleGeometricObject extends SimpleGeometricObject{
    double radius;

    public CircleFromSimpleGeometricObject( double radius,String color, boolean filled){
        super(color,filled);
        this.radius = radius;
    }

    public String toString() {
        return super.toString() + "\nradius is " + radius;
    }

    public static void main(String[] args) {
        CircleFromSimpleGeometricObject circle=new CircleFromSimpleGeometricObject(4,"Blue",true);
        System.out.println(circle.toString());

    }
}
