package giai_de.C9.service;


import giai_de.C9.model.DienThoai;
import giai_de.C9.model.DienThoaiChinhHang;
import giai_de.C9.model.DienThoaiXachTay;
import giai_de.C9.utils.ReadAndWriteToCsv;
import giai_de.C9.utils.Validation;

import java.util.List;
import java.util.Scanner;

public class DienThoaiServiceImpl implements IDienThoaiService {
    static final String DANH_SACH_DIEN_THOAI = "src/giai_de/C9/data/DienThoai.csv";

    @Override
    public void themMoiDienThoai() {
        List<DienThoai> danhSachDienThoai = ReadAndWriteToCsv.readFileToCSV(DANH_SACH_DIEN_THOAI);
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println("Thêm mới điện thoại\n" +
                    "1. Điện thoại chính hãng. \n" +
                    "2. Điện thoạt xách tay \n" +
                    "3. Thoát\n");
            while (true) {
                try {
                    System.out.println("Nhập lựa chọn ");
                    choice = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Sai định dạng nhập, mời nhập lại ");
                }
            }
            switch (choice) {
                case 1:
                    productType(1);
                    break;
                case 2:
                    productType(2);
                    break;
                case 3:
                    break;
            }
        } while (choice != 3);
    }

    @Override
    public void hienThiDanhSachDienThoai() {
        List<DienThoai> danhSachDienThoai = ReadAndWriteToCsv.readFileToCSV(DANH_SACH_DIEN_THOAI);
        for (DienThoai dienThoai : danhSachDienThoai) {
            System.out.println(dienThoai);
        }
    }

    @Override
    public void xoaDienThoai() {
//        List<DienThoai> danhSachDienThoai = ReadAndWriteToCsv.readFileToCSV(DANH_SACH_DIEN_THOAI);
//        Scanner scanner = new Scanner(System.in);
//        hienThiDanhSachDienThoai();
//        System.out.println("Nhập ID điện thoại muốn xóa:  ");
//        int nhapID = Integer.parseInt(scanner.nextLine());
//        boolean kiemTra = false;
//        int viTri = 0;
//        for (int i = 0; i < danhSachDienThoai.size(); i++) {
//            if (danhSachDienThoai.get(i).getIdDienthoai() == nhapID) {
//                viTri = i;
//                kiemTra = true;
//                break;
//            }
//        }
//        if (kiemTra) {
//            boolean flag = false;
//            do {
//                int xacNhan = 0;
//                try {
//                    System.out.println("Bạn muốn xóa điện thoại");
//                    System.out.println("1. Có\n" +
//                            "2. Không");
//                    System.out.println("Mời bạn chọn: ");
//                    xacNhan = Integer.parseInt(scanner.nextLine());
//                    break;
//                } catch (NumberFormatException e) {
//                    System.out.println("Sai định dạng, vui lòng nhập lại");
//                }
//                switch (xacNhan) {
//                    case 1:
//                        danhSachDienThoai.remove(viTri);
//                        ReadAndWriteToCsv.writeListListToFile(danhSachDienThoai, DANH_SACH_DIEN_THOAI);
//                        System.out.println("Đã xóa thành công");
//                        break;
//                    case 2:
//                        System.out.println("Bạn đã hủy xóa");
//                        break;
//                    default:
//                        System.out.println("Hãy nhập lại 1 or 2");
//                }
//            } while (flag);
//        }

    }

    @Override
    public void timkiemDienThoai() {
        List<DienThoai> danhSachDienThoai = ReadAndWriteToCsv.readFileToCSV(DANH_SACH_DIEN_THOAI);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            hienThiDanhSachDienThoai();
            System.out.println("Nhập ID hoặc tên sản phẩm bạn muốn tìm kiếm");
            String timKiem = scanner.nextLine();

            if (timKiem.trim().equals("")) {
                System.out.println("Không để trống, vui lòng nhập lại: ");
            } else {
                boolean flag = false;
                for (DienThoai dienThoai : danhSachDienThoai) {
                    if (dienThoai.getTenDienThoai().toLowerCase().contains(timKiem.toLowerCase()) ||
                            timKiem.equals(String.valueOf(dienThoai.getIdDienthoai()))) {
                        System.out.println("Sản phẩm bạn tìm kiếm: ");
                        System.out.println(dienThoai);
                        flag = true;
                    }
                }
                if (!flag) {
                    System.out.println("Không tìm thấy, vui lòng nhập lại");
                } else {
                    break;
                }
            }
        }
    }

    private void productType(int choice) {
        List<DienThoai> danhSachDienThoai = ReadAndWriteToCsv.readFileToCSV(DANH_SACH_DIEN_THOAI);
        int id = 1;
        if (!danhSachDienThoai.isEmpty()) {
            id = danhSachDienThoai.get(danhSachDienThoai.size() - 1).getIdDienthoai() + 1;
        }

        String tenDienThoai = Validation.resultStringValidation("Nhập tên điện thoại: ");

        double giaBan = Validation.resultDoubleValidation("Nhập giá bán:  ");

        int soluong = Validation.resultIntValidation("Nhập số lượng : ");

        String nhaSanXuat = Validation.resultStringValidation("Nhập nhà sản xuất : ");


        if (choice == 1) {

            String thoiGianBaoHanh = Validation.resultStringValidation("Nhập thời gian bảo hành ");

            String phamViBaoHanh = Validation.resultStringValidation("Nhập pham vi bảo hành: ");

            DienThoai dienThoaiChinhHanh = new DienThoaiChinhHang(id, tenDienThoai, giaBan, soluong, nhaSanXuat, thoiGianBaoHanh, phamViBaoHanh);

            danhSachDienThoai.add(dienThoaiChinhHanh);
            ReadAndWriteToCsv.writeFileObjectToCsv(dienThoaiChinhHanh, DANH_SACH_DIEN_THOAI);


        } else if (choice == 2) {

            String quocGia = Validation.resultStringValidation("Nhập quốc gia xách tay:  ");

            String trangThai = Validation.resultStringValidation("Nhập trạng thái của máy: ");

            DienThoai dienThoaiXachTay = new DienThoaiXachTay(id, tenDienThoai, giaBan, soluong, nhaSanXuat, quocGia, trangThai);
            danhSachDienThoai.add(dienThoaiXachTay);
            ReadAndWriteToCsv.writeFileObjectToCsv(dienThoaiXachTay, DANH_SACH_DIEN_THOAI);
        }
    }
}
