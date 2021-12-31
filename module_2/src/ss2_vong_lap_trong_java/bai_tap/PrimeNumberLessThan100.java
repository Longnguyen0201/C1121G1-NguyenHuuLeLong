package ss2_vong_lap_trong_java.bai_tap;

public class PrimeNumberLessThan100 {
    public static void main(String[] args) {
        int j =2;
        while (j<100){
            boolean flag=true;
            for (int i = 2; i <= Math.sqrt(j); i++) {
                if (j % i == 0) {
                   flag =false;
                   break;
                }
            }
            if (flag){
                System.out.print(j+" ");
            }
            j++;
        }
    }
}
