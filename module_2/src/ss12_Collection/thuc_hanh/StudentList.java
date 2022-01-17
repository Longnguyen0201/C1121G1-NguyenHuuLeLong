package ss12_Collection.thuc_hanh;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class StudentList {
    public static void main(String[] args) {
        Map<String, Integer> hashMapStudent = new HashMap<>();
        hashMapStudent.put("Smith", 30);
        hashMapStudent.put("Anderson", 31);
        hashMapStudent.put("Lewis", 29);
        hashMapStudent.put("Cook", 29);
        System.out.println("Display entries in HashMap");
        System.out.println(hashMapStudent);

        Map< String, Integer> treeMapStuden = new TreeMap<>(hashMapStudent);
        System.out.println("Display entries in ascending order of key");
        System.out.println(treeMapStuden);

        Map<String,Integer> linkedHashMap = new LinkedHashMap<>(16, 0.75f , true);
        linkedHashMap.put("Smith", 30);
        linkedHashMap.put("Anderson", 31);
        linkedHashMap.put("Lewis", 29);
        linkedHashMap.put("Cook", 29);
        System.out.println("\nThe age for" + "Lewis is "+ linkedHashMap.get("Lewis"));
    }
}
