package ss11_stack_and_queue.bai_tap.ReverseElementByStack;

import java.util.Scanner;
import java.util.Stack;

public class ReverseElementOfString {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print(" Enter your String: ");
        String string = input.nextLine();
        System.out.println("Befor string: "+string);

        Stack<String> wStack = new Stack<>();
        String[]  stringArray = string.split("");
        for (int i = 0; i< stringArray.length; i++){
            wStack.push( stringArray[i]);
        }
        String reverseString ="";
        for (int j = 0;j < stringArray.length;j++){
            reverseString += wStack.pop();
        }
        System.out.println("After string: "+reverseString);


    }
}
