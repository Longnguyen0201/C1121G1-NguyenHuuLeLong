package ss13_thuat_toan_tim_kiem.bai_tap.search_max_ascending_string;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String string = input.nextLine();


        LinkedList<Character> maxAscendingString = new LinkedList<>();
        for (int i = 0; i < string.length(); i++) {
            LinkedList<Character> list = new LinkedList<>();
            list.add(string.charAt(i));
            for (int j = i+1; j < string.length(); j++) {
                if (string.charAt(j) > list.getLast()) {
                    list.add(string.charAt(j));
                }
            }

            if (maxAscendingString.size() < list.size()) {
                maxAscendingString.clear();
                maxAscendingString.addAll(list);
            }
            list.clear();
        }
        for (Character element : maxAscendingString) {
            System.out.print( element);
        }

    }



}
