package ss1_introduction_to_java.bai_tap;

import java.util.Scanner;

public class ReadNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print(" Enter number: ");
        int number = sc.nextInt();
        int uints = number % 10;
        int dozens = number % 100 / 10;
        int hundreds = number / 100;

        if (number < 10 && number > 0) {
            System.out.println(unintsNumber(uints));
        } else if (number < 20) {
            System.out.println(specialNumber(number));
        } else if (number < 100) {
            System.out.println(dozensNumber(dozens) + " " + unintsNumber(uints));
        } else if (number < 1000) {
            System.out.println(hundredsNumber(hundreds) + " " + dozensNumber(dozens) + " " + unintsNumber(uints));
        } else {
            System.out.println(" số quá lớn ");
        }

    }

    public static String unintsNumber(int number) {
        String string = "";
        switch (number) {
            case 1:
                string += "one";
                break;
            case 2:
                string += "two";
                break;
            case 3:
                string += "three";
                break;
            case 4:
                string += "four";
                break;
            case 5:
                string += "five";
                break;
            case 6:
                string += "six";
                break;
            case 7:
                string += "seven";
                break;
            case 8:
                string += "eight";
                break;
            case 9:
                string += "nine";
                break;
        }
        return string;
    }

    public static String dozensNumber(int number) {
        String string = "";
        switch (number) {

            case 2:
                string += "twenty";
                break;
            case 3:
                string += "thirty";
                break;
            case 4:
                string += "fourty";
                break;
            case 5:
                string += "fifty";
                break;
            case 6:
                string += "sixty";
                break;
            case 7:
                string += "seventy";
                break;
            case 8:
                string += "eighty";
                break;
            case 9:
                string += "ninety";
                break;
        }
        return string;
    }

    public static String hundredsNumber(int number) {
        String string = "";
        switch (number) {
            case 1:
                string += "One hundreds ";
            case 2:
                string += "Two hundreds";
                break;
            case 3:
                string += "Three hundreds";
                break;
            case 4:
                string += "Four hundreds";
                break;
            case 5:
                string += "Five hundreds";
                break;
            case 6:
                string += "Six hundreds";
                break;
            case 7:
                string += "Seven hundreds";
                break;
            case 8:
                string += "Eight hundreds";
                break;
            case 9:
                string += "Nine hundreds";
                break;
        }
        return string;
    }

    public static String specialNumber(int number) {
        String string = "";
        switch (number) {
            case 10:
                string += " ten";
                break;
            case 11:
                string += " eleven";
                break;
            case 12:
                string += " twelve";
                break;
            case 13:
                string += " thirteen";
                break;
            case 14:
                string += " fourteen";
                break;
            case 15:
                string += " fifteen";
                break;
            case 16:
                string += " sixteen";
                break;
            case 17:
                string += " seventeen";
                break;
            case 18:
                string += " eighteen";
                break;
            case 19:
                string += " nineteen";
                break;
        }
        return string;
    }
}


