package ss21_design_patterns.bai_tap.factory_method;

public class FactoryPatternDemo  {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();

        Shape shape1 = shapeFactory.getShape("Circle");
        System.out.println(" Shape 1 is: ");
        shape1.draw();

        Shape shape2 = shapeFactory.getShape("Square");
        System.out.println("Shape 2 is: ");
        shape2.draw();

        Shape shape3 = shapeFactory.getShape("Rectangle");
        System.out.println("Shape 3 is: " );
        shape3.draw();
    }
}
