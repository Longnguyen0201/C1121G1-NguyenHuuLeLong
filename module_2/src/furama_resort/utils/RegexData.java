package furama_resort.utils;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Pattern;

public class RegexData {
    static Scanner scanner = new Scanner(System.in);

    public static String regex(String temp, String regex, String error){
        boolean check = true;
        do {
            if (temp.matches(regex)){
                check=false;
            }else {
                System.out.println("Wrong format input ( "+ error +" ) \n Please Input again: ");
                temp = scanner.nextLine();
            }
        }while (check);
    return temp;
    }

    public static  String regexAge(String temp, String regex){
        boolean check = true;
        while (check){
            try {
                if (Pattern.matches(regex, temp)) {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate age = LocalDate.parse(temp, formatter);
                    LocalDate now = LocalDate.now();
                    int current = Period.between(age, now).getYears();
                    if (current < 100 && current > 18) {
                        check = false;
                    } else {
                        throw new AgeException("Wrong value limit (18 < age < 100) , Please re-enter:");
                    }
                } else {
                    throw new AgeException("Wrong format input");
                }
            }catch (AgeException e){
                System.out.println(e.getMessage());
                temp = scanner.nextLine();
            }
        }
        return temp ;
    }
}
