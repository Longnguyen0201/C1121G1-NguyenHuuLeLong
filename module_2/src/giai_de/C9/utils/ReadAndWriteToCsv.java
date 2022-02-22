package giai_de.C9.utils;

import giai_de.C9.model.DienThoai;
import giai_de.C9.model.DienThoaiChinhHang;
import giai_de.C9.model.DienThoaiXachTay;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteToCsv {
    public static List<DienThoai> readFileToCSV(String filePath) {
        List<DienThoai> danhSachDienThoai = new ArrayList<>();
        try {
            File file = new File(filePath);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            String[] dienThoai;
            while ((line = bufferedReader.readLine()) != null) {
                dienThoai = line.split(",");
                if (dienThoai[6].equals("Toan Quoc")||dienThoai[6].equals("Quoc Te")) {
                    DienThoaiChinhHang dienThoaiChinhHang = new DienThoaiChinhHang(Integer.parseInt(dienThoai[0]), dienThoai[1], Double.parseDouble(dienThoai[2]),
                            Integer.parseInt(dienThoai[3]), dienThoai[4], dienThoai[5],dienThoai[6]);
                    danhSachDienThoai.add(dienThoaiChinhHang);

                } else {
                    DienThoaiXachTay dienThoaiXachTay = new DienThoaiXachTay(Integer.parseInt(dienThoai[0]), dienThoai[1],Double.parseDouble(dienThoai[2]),
                            Integer.parseInt(dienThoai[3]), dienThoai[4], dienThoai[5],dienThoai[6]);
                    danhSachDienThoai.add(dienThoaiXachTay);
                }
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return danhSachDienThoai;
    }

    public static void writeFileObjectToCsv(DienThoai dienThoai, String filePath) {
        try {
            FileWriter fileWriter = new FileWriter(filePath, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(dienThoai.writeToFileCsv());
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (Exception e) {
            System.err.println("File not found or failure");
            e.printStackTrace();
        }
    }
    public static void writeListListToFile( List<DienThoai> danhSachDienThoai,String filePath) {
        try {
            File file = new File(filePath);
            file.delete();
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (DienThoai dienThoai: danhSachDienThoai) {
                bufferedWriter.write(dienThoai.writeToFileCsv());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
