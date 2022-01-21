package ss16_io_text_file.thuc_hanh.max_number_in_the_text;

import java.util.List;

public class FindMaxValue {
    public static  int findMax (List<Integer> number){
        int max = number.get(0);
        for (int i = 0; i < number.size(); i++) {
            if (max < number.get(i)){
                max = number.get(i);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();
        List <Integer> numbers = readAndWriteFile.readFile("src/ss16_io_text_file/thuc_hanh/max_number_in_the_text/number.txt");
        int maxValue = findMax(numbers);
        readAndWriteFile.wrileFile("src/ss16_io_text_file/thuc_hanh/max_number_in_the_text/result.txt",maxValue);
    }
}
