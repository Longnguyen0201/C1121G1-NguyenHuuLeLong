package ss16_io_text_file.bai_tap.copy_file_text;

public class Main {
    public static void main(String[] args) {
        ReadAndWriteFile readAndWriteFile =new ReadAndWriteFile();
        String sourceFile = "src/ss16_io_text_file/bai_tap/copy_file_text/source_file";
        String targetFile = "src/ss16_io_text_file/bai_tap/copy_file_text/target_file";
        readAndWriteFile.readFile(sourceFile,targetFile);
    }
}
