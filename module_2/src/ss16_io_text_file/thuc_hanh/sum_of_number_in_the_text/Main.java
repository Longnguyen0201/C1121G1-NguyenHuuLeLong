package ss16_io_text_file.thuc_hanh.sum_of_number_in_the_text;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Nhập đường dẫn file");
        Scanner scanner =new Scanner(System.in);
        String path = scanner.nextLine();

        ReadFileExample readFileExample =new ReadFileExample();
        readFileExample.readFileText(path);
    }
}
