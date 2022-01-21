package ss16_io_text_file.bai_tap.read_file_csv;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class ReadFile {
    public ArrayList<National> readFile (String filePath){
        ArrayList<National> nationalList = new ArrayList<>();
        try {
            File file =new File(filePath);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader =new BufferedReader(fileReader);
            String line = "";
            String[] national;
            while ((line=bufferedReader.readLine()) != null){
                national = line.split(",");
                nationalList.add(new National(Integer.parseInt(national[0]),national[1],national[2]));
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return nationalList;
    }
}
