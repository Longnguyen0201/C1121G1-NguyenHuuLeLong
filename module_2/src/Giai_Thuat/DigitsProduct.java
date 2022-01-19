package Giai_Thuat;

public class DigitsProduct {
    public static void main(String[] args) {
        System.out.println(solution(12));
        System.out.println(solution(19));
        System.out.println(solution(26));
    }
    static int solution(int product) {

        String string = "";
        for (int i = 9; i> 1; i--){
            while (product % i == 0){
                product = product / i;
                string = i + string;
            }
        }
        if(product > 1) {
            return -1;
        }
        return Integer.parseInt(string);
    }
}
