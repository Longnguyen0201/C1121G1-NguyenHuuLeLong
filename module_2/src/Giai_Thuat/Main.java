package Giai_Thuat;

public class Main {
    public static boolean isPronic(int number) {
        if (number == 0) {
            return true;
        } else {
            for (int i = 1; i < number; i++) {
                if (number == i * (i + 1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {


        System.out.println(isPronic(-2));
        System.out.println(isPronic(0));
    }
}
