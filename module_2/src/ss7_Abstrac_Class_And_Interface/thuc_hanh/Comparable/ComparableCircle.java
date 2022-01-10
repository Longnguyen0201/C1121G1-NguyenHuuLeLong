package ss7_Abstrac_Class_And_Interface.thuc_hanh.Comparable;

import ss6_inheritance.thuc_hanh.Circle;

public class ComparableCircle extends Circle implements Comparable< Circle> {
    public ComparableCircle() {
    }

    public ComparableCircle(double radius) {
        super(radius);
    }

    public ComparableCircle(double radius, String color, boolean filled) {
        super(radius, color, filled);
    }


    @Override
    public int compareTo(Circle o) {
        if (getRadius() > o.getRadius()) return 1;
        else if (getRadius() < o.getRadius()) return -1;
        else return 1;
    }
}
