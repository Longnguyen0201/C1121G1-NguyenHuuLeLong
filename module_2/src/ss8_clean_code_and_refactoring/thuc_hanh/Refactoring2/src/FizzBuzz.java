package ss8_clean_code_and_refactoring.thuc_hanh.Refactoring2.src;

public class FizzBuzz {
    public static String fizzBuzz(int number){
        boolean isBuzz = number % 5 == 0;
        boolean isFizz = number % 3 == 0;
        if(isFizz && isBuzz)
            return "FizzBuzz";


        if(isFizz)
            return "Fizz";

        if(isBuzz)
            return "Buzz";

        return number + "";
    }
}
