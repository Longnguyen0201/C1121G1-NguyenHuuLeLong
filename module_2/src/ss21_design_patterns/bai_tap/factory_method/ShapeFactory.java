package ss21_design_patterns.bai_tap.factory_method;

public class ShapeFactory {
    public Shape getShape(String type){
        if (type.equals("Circle")){
            return new Circle();
        }else if (type.equals("Square")){
            return new Square();
        }else return new Rectangle();
    }
}
