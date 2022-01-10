package ss7_Abstrac_Class_And_Interface.bai_tap.Resizeable;

public class Main {
    public static void main(String[] args) {

        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(4.5);
        shapes[1] = new Rectangle(4.0, 8.3);
        shapes[2] = new Square(6);
        System.out.println(" Befor:");
        for (Shape shape : shapes) {
            System.out.println(shape);
        }
        System.out.println("After:");
        for (Shape shape : shapes) {
            double random = Math.floor(Math.random() * 100);
            ((Resizeable)shape).resize(random);
        }
        for (Shape shape : shapes) {
            System.out.println(shape);
        }
    }
}
