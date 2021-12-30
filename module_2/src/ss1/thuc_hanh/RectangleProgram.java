package ss1.thuc_hanh;

import java.util.Scanner;

public class RectangleProgram {
    public static void main(String[] args){
        float height;
        float width;

        Scanner scanner= new Scanner(System.in);

        System.out.println("Enter Width: ");
        width =scanner.nextFloat();

        System.out.println("Enter Height: ");
        height =scanner.nextFloat();

        float area = width * height;
        System.out.println("Area is : "+ area);
    }
}
