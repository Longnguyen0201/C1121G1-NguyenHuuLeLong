package ss7_Abstrac_Class_And_Interface.bai_tap.Colorable;

public class Main {
    public static void main(String[] args) {
        Shape[] shape = new Shape[3];
        shape[0]= new Circle(4.6);
        shape[1] = new Square(5);
        shape[2] = new Square(7);

        for (Shape shapes: shape){
            if (shapes instanceof Colorable){
                System.out.println( shapes);
                ((Colorable) shapes).howToColor();
            }else {
                System.out.println(shapes);
            }
        }
    }
}
