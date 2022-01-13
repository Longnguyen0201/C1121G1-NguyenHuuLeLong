package ss11_stack_and_queue.bai_tap.BracketQueue;

import java.util.Scanner;
import java.util.Stack;

public class BracketQueue {
    public static void main(String[] args) {
        Scanner input =new Scanner(System.in);
        System.out.print(" Enter string : ");
        String string = input.nextLine();
        System.out.println( string);

        if (checkBracket(string)){
            System.out.println(" Well");
        }else {
            System.out.println(" Not well");
        }
    }

    public static boolean checkBracket(String string){
        Stack<Character> stack = new Stack<>();
        char symbol;
        boolean flag = false;
        for (int i = 0; i < string.length(); i++) {
            symbol = string.charAt(i);
            if (symbol == '(') {
                stack.push(symbol);
            }
            if (symbol == ')') {
                if (!stack.empty()) {
                    flag = true;
                    stack.pop();
                } else {
                    flag = false;
                    break;
                }
            }
        }
        if (!stack.empty()){
            flag = false;
        }
        return flag;
    }

}
