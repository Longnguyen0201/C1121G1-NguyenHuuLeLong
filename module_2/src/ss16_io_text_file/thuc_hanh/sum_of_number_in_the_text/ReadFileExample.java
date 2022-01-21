package ss16_io_text_file.thuc_hanh.sum_of_number_in_the_text;

import java.io.*;
import java.util.Scanner;

public class ReadFileExample {
    public void readFileText(String filePath){
        try {
            File file =new File(filePath);
            if ( !file.exists()){
                throw new FileNotFoundException();
            }
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = "";
            int sum =0;
            while ((line = bufferedReader.readLine()) != null){
                System.out.println(line);
                sum+= Integer.parseInt(line);
            }
            bufferedReader.close();
            System.out.println("Tổng = "+sum);
        } catch (FileNotFoundException e) {
            System.err.println("File không tồn lại");;
        } catch (IOException e) {
            System.err.println("Flie có nội dung lỗi");;
        }
    }
}
