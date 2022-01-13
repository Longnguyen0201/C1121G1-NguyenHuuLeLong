package ss11_stack_and_queue.bai_tap.TreeMap;

import java.util.Scanner;
import java.util.TreeMap;

public class TreeMapCharacter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner( System.in );
        System.out.println( "Enter string: " );
        String string = scanner.nextLine().toLowerCase();

        TreeMap<Character,Integer> treeMap =new TreeMap<>();
        int count = 1;
        for (int i=0 ; i< string.length();i++){
            char character = string.charAt(i);
            if (treeMap.containsKey(character)){
                treeMap.put(character,count +1);
            }else {
                treeMap.put(character,count);
            }
        }
        System.out.println( treeMap);

    }
}
