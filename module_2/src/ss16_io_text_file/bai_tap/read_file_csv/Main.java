package ss16_io_text_file.bai_tap.read_file_csv;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ReadFile readFile =new ReadFile();
        ArrayList<National> nationals = readFile.readFile("src/ss16_io_text_file/bai_tap/read_file_csv/national.csv");
        System.out.println( "List national from file");
        for (National national : nationals) {
            System.out.println(national.toString());
        }
    }
}
