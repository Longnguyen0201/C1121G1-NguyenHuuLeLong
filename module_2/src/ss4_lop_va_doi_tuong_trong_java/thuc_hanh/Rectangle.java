package ss4_lop_va_doi_tuong_trong_java.thuc_hanh;

import java.util.Scanner;

public class Rectangle {
    double width;
    double height;

    public Rectangle() {

    }

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getArea() {
        return this.width * this.height;
    }

    public double getPerimeter() {
        return (this.width + this.height) * 2;
    }
    public String dislay(){
        return "Retangle{"+" width= " +width+", height= "+ height+ "}";
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the width: ");
        double width = input.nextDouble();
        System.out.print("Enter the height: ");
        double height = input.nextDouble();

        Rectangle rectangle = new Rectangle(width,height);
        System.out.println("Your Rectangle \n"+rectangle.dislay());
        System.out.println("Area of the rectangle: "+ rectangle.getArea());
        System.out.println("Perimeter of the rectangle: "+ rectangle.getPerimeter());
    }
}
