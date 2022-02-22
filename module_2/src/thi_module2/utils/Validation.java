package thi_module2.utils;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Validation {
    public static String regex(String chuoiNhap, String regex, String err){
        Scanner scanner =new Scanner(System.in);
        boolean kiemTra = true;
        do {
            if (chuoiNhap.matches(regex)){
                kiemTra=false;
            }else {
                System.out.println("Sai định dạng ( "+ err +" ) \n vui lòng nhập lại: ");
                chuoiNhap = scanner.nextLine();
            }
        }while (kiemTra);
        return chuoiNhap;
    }

//    public static boolean regex(String ngayNhapVien, String ngayRaVien){
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//
//    }
}
