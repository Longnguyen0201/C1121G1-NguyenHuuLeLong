package ss17_io_binary.thuc_hanh.read_write_list_of_studen_io_binary;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Vũ Kiều Anh", "Hà Nội"));
        students.add(new Student(2, "Nguyễn Minh Quân", "Hà Nội"));
        students.add(new Student(3, "Đặng Huy Hoà", "Đà Nẵng"));
        students.add(new Student(4, "Nguyễn Khánh Tùng", "Hà Nội"));
        students.add(new Student(5, "Nguyễn Khắc Nhật", "Hà Nội"));
        writeToFile("src/ss17_io_binary/thuc_hanh/read_write_list_of_studen_io_binary/student.txt", students);

        List<Student> studentDataFromFile = readDatafromFlie("src/ss17_io_binary/thuc_hanh/read_write_list_of_studen_io_binary/student.txt");
        for (Student student : studentDataFromFile) {
            System.out.println(student);
        }
    }
    public static void writeToFile(String path, List<Student> students){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(students);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<Student> readDatafromFlie(String path){
        List<Student> students = new ArrayList<>();
        try {
            FileInputStream fileInputStream =new FileInputStream(path);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            students = (List<Student>) objectInputStream.readObject();
            fileInputStream.close();
            objectInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;

    }
}
