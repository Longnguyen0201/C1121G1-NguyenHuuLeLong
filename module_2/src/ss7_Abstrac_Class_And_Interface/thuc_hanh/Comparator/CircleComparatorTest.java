package ss7_Abstrac_Class_And_Interface.thuc_hanh.Comparator;

import ss6_inheritance.thuc_hanh.Circle;
import java.util.Arrays;

public class CircleComparatorTest {
    public static void main(String[] args) {
        Circle[] circles = new Circle[3];
        circles[0] = new Circle(3.6);
        circles[1] = new Circle();
        circles[2] =new Circle(3.2, "red", false);
        System.out.println("Pre-sorted: ");
        for (Circle circle: circles){
            System.out.println(Arrays.toString(new Circle[]{circle}));
        }

        CircleComparator circleComparator = new CircleComparator();
        Arrays.sort(circles, circleComparator);

        System.out.println("After-sorted:");
        for (Circle circle : circles) {
            System.out.println(circle);
        }
    }
}
