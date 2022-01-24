package ss17_io_binary.thuc_hanh.copy_large_file;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class Main{
    private static void copyFileUsingJava7Files (File source, File dest) throws IOException {
        Files.copy(source.toPath(),dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }

    private static void copyFileUsingStream(File source, File dest) throws IOException{
        InputStream in = null;
        OutputStream out = null;

        try {
            in = new FileInputStream( source);
            out =new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = in.read(buffer)) >0){
                out.write(buffer,0,length);
            }
        }finally {
            in.close();
            out.close();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter source file");
        String sourcePath = scanner.nextLine();
        System.out.println("Enter dest file");
        String destPath = scanner.nextLine();

        File sourceFile = new File(sourcePath);
        File destFile = new File(destPath);

        try {
            copyFileUsingJava7Files(sourceFile,destFile);
            System.out.println("Copy completed");
        } catch (IOException e) {
            System.out.println("Can't copy file.");
            System.out.println(scanner.ioException().getMessage());
        }
    }




}
