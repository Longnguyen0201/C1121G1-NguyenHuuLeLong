package ss4_lop_va_doi_tuong_trong_java.thuc_hanh;

import java.util.Arrays;
import java.util.Stack;


public class GiaiThuat {
    public static void main(String[] args) {
        int [] a = {7,2,5,3,5,3};
        int [] b = {7,2,5,4,6,3,5,3};
        Stack <Integer> c = new Stack<>();
        for (int i=0; i< b.length; i++){
            boolean flag =true;
            for (int j=0; j<a .length;j++){
                if (a[j] == b[i]){
                    flag =false;
                    break;
                }
            }
            if (flag){
                c.push(b[i]);
            }
        }
        System.out.println(c);
    }
}
