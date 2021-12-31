package ss3_mang_va_phuong_thuc_trong_java.bai_tap;

import java.util.Scanner;

public class FindMaxElemetIn2WayArray {
    public static void main(String[] args) {
        float[][] matrix= new float[5][5];
        double max = matrix[0][0];
        Scanner input= new Scanner(System.in);

        for (int i=0;i<matrix.length;i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(" Enter matrix is position "+ i+"-"+j+":");
                matrix[i][j]= input.nextFloat();
            }
        }

        for (int i=0;i<matrix.length;i++){
            for (int j=0; j< matrix[i].length;j++){
                if (matrix[i][j]> max){
                    max = matrix[i][j];
                }
            }
        }
        System.out.println(" Max element in array is: "+ max);
    }
}
