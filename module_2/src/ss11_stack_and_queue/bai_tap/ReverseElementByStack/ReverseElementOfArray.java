package ss11_stack_and_queue.bai_tap.ReverseElementByStack;


import java.util.*;

public class ReverseElementOfArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println(" Enter element number of array:  ");
        int size = Integer.parseInt(input.nextLine());
        int[] array = new int[size];
        Stack<Integer> myStack = new Stack<>();
        for (int i =0 ; i< size; i++){
            System.out.print("Enter element "+ (i+1)+": ");
            array[i] = Integer.parseInt(input.nextLine());
            myStack.push(array[i]);
        }
        System.out.println( myStack);

        for ( int i =0 ; i < size; i++ ){
            array[i] = myStack.pop();
        }
        System.out.println(Arrays.toString(array));

    }
}
