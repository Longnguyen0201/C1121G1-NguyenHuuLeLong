package ss15_exception_and_debug.thuc_hanh;

import java.util.Random;
import java.util.Scanner;

public class ArrayExample {
    public static Integer[] createRandom(){
        Random random = new Random();
        Integer[] array = new Integer[100];
        System.out.println("Your array:");
        for (int i = 0; i < 100; i++) {
            array[i] = random.nextInt(100);
            System.out.print(array[i]+" ");
        }
        return array;
    }

    public static void main(String[] args) {
        ArrayExample arrayExample = new ArrayExample();
        Integer[] arr =ArrayExample.createRandom();

        Scanner scanner = new Scanner(System.in);
        System.out.println(" Enter index of any element: ");
        int index   = Integer.parseInt(scanner.nextLine());
        try{
            System.out.println(" Value of the element with index  "+ index + " is "+ arr[index]);
        }catch (IndexOutOfBoundsException e){
            System.out.println("Index exceeds the limit of the array");
        }
    }
}
