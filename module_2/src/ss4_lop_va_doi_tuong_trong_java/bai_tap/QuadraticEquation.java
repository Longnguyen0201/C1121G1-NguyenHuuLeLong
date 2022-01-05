package ss4_lop_va_doi_tuong_trong_java.bai_tap;

import java.util.Scanner;

public class QuadraticEquation {
    double a;
    double b;
    double c;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return this.a;
    }

    public double getB() {
        return this.b;
    }

    public double getC() {
        return this.c;
    }

    public double getDiscriminant() {
        return (Math.pow(getB(), 2)) - (4 * getA() * getC());
    }

    public double getRoot1() {
        return ((-getB()) + Math.pow(getDiscriminant(), 0.5)) / (2 * getA());
    }

    public double getRoot2() {
        return ((-getB()) - Math.pow(getDiscriminant(), 0.5)) / (2 * getA());
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a: ");
        double a = input.nextDouble();
        System.out.print("Enter b: ");
        double b = input.nextDouble();
        System.out.print("Enter c: ");
        double c = input.nextDouble();

        QuadraticEquation quadraticEquation = new QuadraticEquation(a, b, c);
        if (quadraticEquation.getDiscriminant() > 0) {
            System.out.println("The equation has two roots " + quadraticEquation.getRoot1() + " and " + quadraticEquation.getRoot2());
        } else if (quadraticEquation.getDiscriminant() == 0) {
            System.out.println("The equation has one roots " + quadraticEquation.getRoot1());
        } else {
            System.out.println(" The equation has no roots");
        }
        System.out.println(quadraticEquation.getDiscriminant());
    }
}
