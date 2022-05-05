package DTO;

public class TheMuonSachDTO {
    private String maMuonSach;
    private String maSach;
    private String tenTacGia;
    private String tenHocSinh;
    private String lop;
    private String ngayMuonSach;
    private String ngayTraSach;

    public TheMuonSachDTO() {
    }

    public TheMuonSachDTO(String maMuonSach, String maSach, String tenTacGia, String tenHocSinh, String lop, String ngayMuonSach, String ngayTraSach) {
        this.maMuonSach = maMuonSach;
        this.maSach = maSach;
        this.tenTacGia = tenTacGia;
        this.tenHocSinh = tenHocSinh;
        this.lop = lop;
        this.ngayMuonSach = ngayMuonSach;
        this.ngayTraSach = ngayTraSach;
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

    public String getTenTacGia() {
        return tenTacGia;
    }

    public void setTenTacGia(String tenTacGia) {
        this.tenTacGia = tenTacGia;
    }

    public String getTenHocSinh() {
        return tenHocSinh;
    }

    public void setTenHocSinh(String tenHocSinh) {
        this.tenHocSinh = tenHocSinh;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
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
