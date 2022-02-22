package thi_module2.servers;


import thi_module2.model.BenhAn;
import thi_module2.model.BenhAnThuong;
import thi_module2.model.BenhAnVip;
import thi_module2.utils.ReadAndWriteToFileCsv;
import thi_module2.utils.Validation;


import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.Scanner;

public class BenhAnServiceImpl implements IBenhAnSerivice {
    public static final String MA_BENH_AN = "^(BA)-\\d{3}$";
    public static final String MA_BENH_NHN = "^(BN)-\\d{3}$";
    public static final String NGAY_THANG = "^[0-3]?[0-9]-[0-3]?[0-9]-(?:[0-9]{2})?[0-9]{2}$";
    public static final String VIP = "^VIP [I]{1,3}$";
    private static final String DANH_SACH_BENH_AN = "src/thi_module2/data/benhan.csv";

    @Override
    public void themMoiBenhAn() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println("Thêm mới bệnh án\n" +
                    "1. Bệnh án bệnh nhân thường. \n" +
                    "2. Bệnh án bệnh nhân VIP \n" +
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
                    chonBenhAn(1);
                    break;
                case 2:
                    chonBenhAn(2);
                    break;
                case 3:
                    break;
            }
        } while (choice != 3);
    }

    @Override
    public void hienThiDanhSachBenhAn() {
        List<BenhAn> danhSachBenhAn = ReadAndWriteToFileCsv.readFileToCSV(DANH_SACH_BENH_AN);
        for (BenhAn benhAn : danhSachBenhAn) {
            System.out.println(benhAn);
        }
    }

    @Override
    public void xoaBenhAn() {
        Scanner scanner = new Scanner(System.in);
        List<BenhAn> danhSachBenhAn = ReadAndWriteToFileCsv.readFileToCSV(DANH_SACH_BENH_AN);
        boolean flag = false;
        System.out.println("Nhập mã bệnh án bạn muốn xóa: ");
        String timMaBenhAn = scanner.nextLine();
        if (timMaBenhAn.trim().equals("")) {
            System.out.println("Không được để trống mời bạn nhập lại:");
        } else {
            try {
                for (BenhAn benhAn : danhSachBenhAn) {
                    if (benhAn.getMaBenhAn().equals(timMaBenhAn)) {
                        int luaChon = 0;
                        do {
                            System.out.println("bạn có muốn xóa bện án:\n " + benhAn);
                            System.out.println("1. Có\n" +
                                    "2. Không \n");
                            while (true) {
                                try {
                                    System.out.println("Mời bạn chọn ");
                                    luaChon = Integer.parseInt(scanner.nextLine());
                                    break;
                                } catch (NumberFormatException e) {
                                    System.out.println("Sai định dạng nhập vào, mời bạn chọn lại ");
                                }
                            }
                            switch (luaChon) {
                                case 1:
                                    danhSachBenhAn.remove(benhAn);
                                    ReadAndWriteToFileCsv.writeListListToFile(danhSachBenhAn, DANH_SACH_BENH_AN);
                                    hienThiDanhSachBenhAn();
                                    System.out.println("Đã xóa bẹnh án thành công.");
//                                    System.exit(1);
                                    break;
                                case 2:
                                    System.out.println("Bạn đã hủy xóa bệnh án.");
                                    break;
                                default:
                                    flag = true;
                                    System.out.println("Vui lòng bấm 1 hoặc 2");
                            }
                        } while (flag);
                    } else {
                        System.out.println("Không tìm thấy Bệnh án.");
                    }
                }
            } catch (ConcurrentModificationException e) {
                System.out.println("\n");
            }
        }
    }

    private void chonBenhAn(int chon) {
        Scanner scanner = new Scanner(System.in);
        List<BenhAn> danhSachBenhAn = ReadAndWriteToFileCsv.readFileToCSV(DANH_SACH_BENH_AN);
        int soThuTu = 1;
        if (!danhSachBenhAn.isEmpty()) {
            soThuTu = danhSachBenhAn.get(danhSachBenhAn.size() - 1).getSoThuTu() + 1;
        }
        System.out.println("Nhập mã bệnh án: ");
        String maBenhAn = Validation.regex(scanner.nextLine(), MA_BENH_AN, "BA-XXX");

        System.out.println("Nhập mã bệnh nhân");
        String maBenhNhan = Validation.regex(scanner.nextLine(), MA_BENH_NHN, "BN-XXX");

        System.out.println("Nhập tên bệnh nhân");
        String tenBenhNhan = scanner.nextLine();

        System.out.println("Nhập ngày nhập viện");
        String ngayNhapVien = Validation.regex(scanner.nextLine(), NGAY_THANG, "dd/MM/yyyy");

        System.out.println("Nhập ngày ra viện");
        String ngayRaVien = Validation.regex(scanner.nextLine(), NGAY_THANG, "dd/MM/yyyy");

        System.out.println("Nhập lý do nhập viện");
        String lyDoNhapVien = scanner.nextLine();

        if (chon == 1) {
            System.out.println("Nhập phí nằm viện");
            int phiNhapVien = Integer.parseInt(scanner.nextLine());
            BenhAnThuong benhAnThuong = new BenhAnThuong(soThuTu, maBenhAn, maBenhNhan, tenBenhNhan, ngayNhapVien, ngayRaVien, lyDoNhapVien, phiNhapVien);
            danhSachBenhAn.add(benhAnThuong);
            ReadAndWriteToFileCsv.writeFileObjectToCsv(benhAnThuong, DANH_SACH_BENH_AN);
        } else {
            System.out.println("Nhập loại VIP: ");
            String loaiVip = Validation.regex(scanner.nextLine(), VIP, "VIP I,VIP II, VIP III");

            System.out.println("Nhập thời hạn VIP");
            String thoiHanVip = Validation.regex(scanner.nextLine(), NGAY_THANG, "dd/MM/yyyy");

            BenhAnVip benhAnVip = new BenhAnVip(soThuTu, maBenhAn, maBenhNhan, tenBenhNhan, ngayNhapVien, ngayRaVien, lyDoNhapVien, loaiVip, thoiHanVip);
            danhSachBenhAn.add(benhAnVip);
            ReadAndWriteToFileCsv.writeFileObjectToCsv(benhAnVip, DANH_SACH_BENH_AN);
        }
    }


}
