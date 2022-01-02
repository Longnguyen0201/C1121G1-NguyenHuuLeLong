package ss3_mang_va_phuong_thuc_trong_java.bai_tap;

import java.util.Scanner;

public class CountTheNumberOfOccurrencesInString {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String string = "abcsdadsc";
        System.out.println("String : " + string);
        System.out.print(" Enter characters to count: ");
        char characters = input.next().charAt(0);
        int count = 0;

        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == characters) {
                count++;
            }
        }
        System.out.println( "Character \""+ characters+ "\" appear in the string " + count + " times.");


    }
}
