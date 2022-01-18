package ss13_thuat_toan_tim_kiem.thuc_hanh;

import java.util.Scanner;

public class AlgorithmComplexityTest {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter a string");
        String inputString = scanner.nextLine() ;

        int[] frequentChar = new int[255];                         //{1}-->O(1)
        for (int i = 0; i < inputString.length(); i++) {           //{2}-->O(n)
            /* Tìm ví trí tương ứng của ký tự trong bảng ASCII */
            int ascii = (int) inputString.charAt(i);               //{3}-->O(1) trong vong lap-->O(n)
            /* Tăng giá trị tần suất */
            frequentChar[ascii] += 1;                              //{4}-->O(1) trong vong lap-->O(n)
        }

        int max =0;                             //{5} --> O(1)
        char character = (char) 255;            //{6} --> O(1)
        for (int j =0 ;j < 255; j++){           //{7} ---> O(255)
            if (frequentChar[j]>max){           //{8} --> O(1) trong vong lap-->O(255)
                max =frequentChar[j];           //{9} --> O(1) trong vong lap-->O(255)
                character = (char) j;           //{10}--> O(1) trong vong lap-->O(255)
            }
        }
        System.out.println("The most appering letter is "+character+" with a frequency of "+ max +" times");
    }

}
