package ss3_mang_va_phuong_thuc_trong_java.thuc_hanh;

class FindMinimun {
    public static void main(String[] args) {
        int[] array = {4, 12, 7, 8, 1, 6, 9};
        int index = minValue(array);
        System.out.println(" The smallest element in the array: " + array[index]);
    }

    public static int minValue(int[] arr) {
        int index = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[index]) {
                index = i;
            }
        }
        return index;
    }

}
