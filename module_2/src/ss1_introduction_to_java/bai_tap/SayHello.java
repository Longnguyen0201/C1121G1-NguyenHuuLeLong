package ss1_introduction_to_java.bai_tap;

import java.util.Scanner;

public class SayHello {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("EnTer a your name: ");
        String name = scanner.next();

        System.out.println("Hello: " + name);

    }
}
