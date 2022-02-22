package thi_module2.model;

public class BenhAnThuong extends BenhAn{
    private double phiNamVien;

    public BenhAnThuong() {
    }

    public BenhAnThuong(int soThuTu, String maBenhAn,String maBenhNhan, String tenBenhNhan, String ngayNhapVien, String ngayRaVien, String lydoNhapVien, double phiNamVien) {
        super(soThuTu, maBenhAn,maBenhNhan, tenBenhNhan, ngayNhapVien, ngayRaVien, lydoNhapVien);
        this.phiNamVien = phiNamVien;
    }

    public double getPhiNamVien() {
        return phiNamVien;
    }

    public void setPhiNamVien(double phiNamVien) {
        this.phiNamVien = phiNamVien;
    }

    @Override
    public String toString() {
        return super.toString() +
                "phiNamVien=" + phiNamVien +
                "}";
    }
    public String writeToCsv() {
        return super.writeToCsv()+","+phiNamVien;
    }
}
