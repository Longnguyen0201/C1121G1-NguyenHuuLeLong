package thi_module2.controller;

import thi_module2.servers.BenhAnServiceImpl;

import java.util.Scanner;

public class QuanLyBenhAn {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BenhAnServiceImpl benhAnService = new BenhAnServiceImpl();
        int chon = 0;
        do {
            System.out.println("Chương trình Quản lý Bệnh án \n" +
                    "1. Thêm mới bệnh án . \n" +
                    "2. Xóa bệnh án \n" +
                    "3. Xem danh sách  bệnh án\n" +
                    "4. Thoát");
            while (true) {
                try {
                    System.out.println("Chọn chức năng");
                    chon = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Sai định dạng, vui lòng nhập lại");
                }
            }
            switch (chon) {
                case 1:
                    benhAnService.themMoiBenhAn();
                    break;
                case 2:
                    benhAnService.xoaBenhAn();
                    break;
                case 3:
benhAnService.hienThiDanhSachBenhAn();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Không có lựu chọn này, vui lòng nhập (từ 1- 5 ): ");
            }
        } while (chon != 5);
    }
}
