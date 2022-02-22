package giai_de.C9.controller;

import giai_de.C9.service.DienThoaiServiceImpl;

import java.util.Scanner;

public class QuanLyDienThoai {
    static DienThoaiServiceImpl dienThoaiService = new DienThoaiServiceImpl();

    public static void main(String[] args) throws Exception, Exception, java.lang.Exception {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println("Quản lý điện thoại \n" +
                    "1. Thêm mới điện thoại . \n" +
                    "2. Xóa điện thoại \n" +
                    "3. Xem danh sách  điện thoại\n" +
                    "4. Tìm kiếm điện thoại\n" +
                    "5. Thoát");
            while (true) {
                try {
                    System.out.println("Chọn chức năng");
                    choice = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Sai định dạng, vui lòng nhập lại");
                }
            }
            switch (choice) {
                case 1:
                    dienThoaiService.themMoiDienThoai();
                    break;
                case 2:
//                    dienThoaiService.xoaDie nThoai();

                    break;
                case 3:
                    dienThoaiService.hienThiDanhSachDienThoai();
                    break;
                case 4:
                    dienThoaiService.timkiemDienThoai();

                    break;
                case 5:
                    break;
                default:
                    System.out.println("Không có lựu chọn này, vui lòng nhập (từ 1- 5 ): ");
            }
        } while (choice != 5);
    }
}
