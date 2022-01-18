package ss13_thuat_toan_tim_kiem.bai_tap.search_max_consecutive_string;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LinkedList<Character> list = new LinkedList<>();
        LinkedList<Character> max = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.print(" Enter string: ");
        String string = scanner.nextLine();

        for (int i = 0; i < string.length(); i++) {
            if (list.size()> 1 && string.charAt(i)<= list.getLast()&& list.contains(string.charAt(i))){
                list.clear();
            }
            list.add(string.charAt(i));
            if (list.size() > max.size()){
                max.clear();
                max. addAll(list);
            }
        }
        for (Character element: max){
            System.out.print( element);
        }

    }
}
