package models;

public class TheMuonSach {
    private String maMuonSach;
    private String maSach;
    private String maHocSinh;
    private Integer trangThai;
    private String ngayMuonSach;
    private String ngayTraSach;

    public TheMuonSach(String maMuonSach, String maSach, String maHocSinh, Integer trangThai, String ngayMuonSach, String ngayTraSach) {
        this.maMuonSach = maMuonSach;
        this.maSach = maSach;
        this.maHocSinh = maHocSinh;
        this.trangThai = trangThai;
        this.ngayMuonSach = ngayMuonSach;
        this.ngayTraSach = ngayTraSach;
    }

    public TheMuonSach() {
    }

    public String getMaMuonSach() {
        return maMuonSach;
    }

    public void setMaMuonSach(String maMuonSach) {
        this.maMuonSach = maMuonSach;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getMaHocSinh() {
        return maHocSinh;
    }

    public void setMaHocSinh(String maHocSinh) {
        this.maHocSinh = maHocSinh;
    }

    public Integer getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Integer trangThai) {
        this.trangThai = trangThai;
    }

    public String getNgayMuonSach() {
        return ngayMuonSach;
    }

    public void setNgayMuonSach(String ngayMuonSach) {
        this.ngayMuonSach = ngayMuonSach;
    }

    public String getNgayTraSach() {
        return ngayTraSach;
    }

    public void setNgayTraSach(String ngayTraSach) {
        this.ngayTraSach = ngayTraSach;
    }
}
