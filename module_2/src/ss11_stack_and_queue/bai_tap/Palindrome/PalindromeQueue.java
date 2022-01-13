package ss11_stack_and_queue.bai_tap.Palindrome;

import java.util.*;

public class PalindromeQueue {
    public static void main(String[] args) {
        Scanner input =new Scanner(System.in);
        System.out.print(" Enter string : ");
        String string = input.nextLine();
        string =string.toLowerCase();

        if (isPalindrome(string)){
            System.out.println("String is palindrome");
        }else {
            System.out.println("String is not palindrome");
        }

    }
    public static boolean isPalindrome(String string){
        Stack<Character> myStack = new Stack<>();
        Queue<Character> myQueue = new LinkedList();

        for (int i=0 ; i < string.length();i++){
            myStack.push(string.charAt(i));
            myQueue.offer(string.charAt(i));
        }
        boolean flag = false;
        while (!myStack.empty()){
            if(myStack.pop()==myQueue.poll()){
                flag= true;
            }else {
                flag=false;
            }
        }return flag;
    }

}
