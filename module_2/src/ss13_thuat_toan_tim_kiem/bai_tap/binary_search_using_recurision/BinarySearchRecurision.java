package ss13_thuat_toan_tim_kiem.bai_tap.binary_search_using_recurision;

public class BinarySearchRecurision {
    static int[] list = {2, 5, 8, 10, 11, 14, 30, 35, 41, 53, 60, 66, 70, 90};

    public static void main(String[] args) {
        int left = 0;
        int right = list.length - 1;
        int value = 8;
        System.out.println("Value "+ value + " at index " + binarySearch(list , left, right, value ));
    }

    public static int binarySearch(int[] array, int left, int right, int value) {
        int middle = (left + right) / 2;

            if (array[middle] == value) {
                return middle;
            } else if (value > array[middle]) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        return binarySearch(array, left, right, value);

    }

}
