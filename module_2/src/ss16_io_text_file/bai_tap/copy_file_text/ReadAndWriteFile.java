package ss16_io_text_file.bai_tap.copy_file_text;

import java.io.*;

public class ReadAndWriteFile {
 public void readFile(String inputFile, String outputFile ){
     try {
         File file = new File(inputFile);
         if (!file.exists()){
             throw new FileNotFoundException();
         }
         BufferedReader reader = new BufferedReader(new FileReader(file));
         FileWriter fileWriter = new FileWriter(outputFile);
         BufferedWriter writer =new BufferedWriter(fileWriter);
         String line= null;
         while ((line = reader.readLine())!= null){
             writer.write(line);
             writer.newLine();
         }
         reader.close();
         writer.close();
         System.out.println("Completed copy file");
     } catch (Exception e) {
         System.out.println("File note found or failure document");
     }
 }
}
