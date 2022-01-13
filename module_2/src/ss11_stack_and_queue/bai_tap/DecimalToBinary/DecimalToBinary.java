package ss11_stack_and_queue.bai_tap.DecimalToBinary;

import java.util.Scanner;
import java.util.Stack;

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner input =new Scanner(System.in);
        System.out.print(" Enter number decimal : ");
        int decimal = Integer.parseInt(input.nextLine());

        Stack<Integer> myStack = new Stack<>();
        int surplus;
        do{
            myStack.push(decimal%2);
            decimal= decimal / 2;

        }while (decimal != 0);
        String binary="";
        System.out.println(myStack);
        while (!myStack.empty()){
            binary += myStack.pop();
        }
        System.out.println( "Binary of the number decimal: " + binary );
    }



}
