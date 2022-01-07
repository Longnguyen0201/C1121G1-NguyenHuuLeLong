package ss6_inheritance.bai_tap.Triangle;

import ss6_inheritance.thuc_hanh.Shape;

public class Main {
    public static void main(String[] args) {
        Shape shape =new Shape();
        System.out.println(shape);
        shape =new Shape("red",false);
        System.out.println(shape);

        Triangle triangle = new Triangle();
        System.out.println(triangle);
        Triangle triangle1 = new Triangle(4.0,6.6,8.4);
        System.out.println(triangle1);
        Triangle triangle2 =new Triangle("Blue",false, 5.0,9.0,12.0);
        System.out.println(triangle2);
    }
}
