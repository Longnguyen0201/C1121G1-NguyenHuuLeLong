package ss8_clean_code_and_refactoring.thuc_hanh.Refactoring3.src;

public class Cylinder {
    public static double getVolume(int radius, int height){
        double baseArea = getBaseArea(radius);
        double perimeter = getPerimeter(radius);
        return perimeter * height + 2 * baseArea;
    }
    private static  double getBaseArea(int radius){
        return Math.PI * radius * radius;
    }
    private static  double getPerimeter(int radius){
        return Math.PI * radius * 2;
    }

}
