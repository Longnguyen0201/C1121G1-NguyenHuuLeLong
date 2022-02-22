package thi_module2.utils;

import giai_de.C9.model.DienThoai;
import thi_module2.model.BenhAn;
import thi_module2.model.BenhAnThuong;
import thi_module2.model.BenhAnVip;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteToFileCsv {
    public static List<BenhAn> readFileToCSV(String filePath) {
        List<BenhAn> danhSachBenhAn = new ArrayList<>();
        try {
            File file = new File(filePath);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            String[] benhAn;
            while ((line = bufferedReader.readLine()) != null) {
                benhAn = line.split(",");
                if (benhAn.length==8) {
                    BenhAnThuong benhAnThuong = new BenhAnThuong(Integer.parseInt(benhAn[0]), benhAn[1], benhAn[2],
                            benhAn[3], benhAn[4], benhAn[5],benhAn[6], Double.parseDouble(benhAn[7]));
                    danhSachBenhAn.add(benhAnThuong);

                } else {
                    BenhAnVip benhAnVip = new BenhAnVip(Integer.parseInt(benhAn[0]), benhAn[1],benhAn[2],
                            benhAn[3], benhAn[4], benhAn[5],benhAn[6],benhAn[7],benhAn[8]);
                    danhSachBenhAn.add(benhAnVip);
                }
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return danhSachBenhAn;
    }
    public static void writeFileObjectToCsv(BenhAn benhAn, String filePath) {
        try {
            FileWriter fileWriter = new FileWriter(filePath, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(benhAn.writeToCsv());
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (Exception e) {
            System.err.println("File not found or failure");
            e.printStackTrace();
        }
    }
    public static void writeListListToFile( List<BenhAn> danhSachBenhAn,String filePath) {
        try {
            File file = new File(filePath);
            file.delete();
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (BenhAn benhAn: danhSachBenhAn) {
                bufferedWriter.write(benhAn.writeToCsv());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
