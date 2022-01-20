package ss15_exception_and_debug.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class main {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int[] triangle;
        boolean flag;
        do {
            flag= false;
            try {
                System.out.println("Nhập 3 cạnh của tam giác");
                triangle = createTriangle();
                System.out.println("triangle = "+ Arrays.toString(triangle));
                flag =true;
            } catch (IllegalTriangleException e) {
                System.err.println("Exception: " + e.getMessage());
                System.err.println(" nhập lại");
            }

        }while (!flag);

    }


    public  static  int[] createTriangle () throws IllegalTriangleException {
        System.out.println(" Enter a :");
        int a = Integer.parseInt(input.nextLine());
        System.out.println(" Enter b :");
        int b = Integer.parseInt(input.nextLine());
        System.out.println(" Enter c :");
        int c = Integer.parseInt(input.nextLine());

        if (a<=0||b<=0||c<=0){
            throw new IllegalTriangleException("Lỗi cạnh tam giác bé hơn 0");
        } else if (a+b<c||a+c<b||b+c<a){
            throw  new IllegalTriangleException(" Tổng 2 cạnh tam giác bé hơn cạnh còn lại");
        }
        int[] triangle = {a,b,c};
        return  triangle;

    }
}
