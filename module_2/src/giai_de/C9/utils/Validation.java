package giai_de.C9.utils;

import java.util.Scanner;

public class Validation {
    public static String resultStringValidation(String text){
        Scanner scanner = new Scanner(System.in);
        String result;
        while (true){
            System.out.println(text);
            result = scanner.nextLine();
            if (result.trim().equals("")){
                System.out.println("Sai định dạng vui lòng nhạp lại");
            }else {
                break;
            }
        }
        return result;
    }
    public static int resultIntValidation(String text){
        Scanner scanner = new Scanner(System.in);
        int result;
        while (true){
            try {
                System.out.println(text);
                result = Integer.parseInt(scanner.nextLine());
                if (result < 0 ){
                    System.out.println("Nhập vào phải là số nguyên dương (giá trị > 0): ");
                }else {
                    break;
                }
            }catch (NumberFormatException e){
                System.out.println("Sai định dạng nhập vào");
            }

        }
        return result;
    }
    public static double resultDoubleValidation(String text){
        Scanner scanner = new Scanner(System.in);
        double result;
        while (true){
            try {
                System.out.println(text);
                result = Double.parseDouble(scanner.nextLine());
                if (result < 0 ){
                    System.out.println("Wrong input, please re-enter (value > 0): ");
                }else {
                    break;
                }
            }catch (NumberFormatException e){
                System.out.println("Wrong format input");
            }
        }
        return result;
    }

}
