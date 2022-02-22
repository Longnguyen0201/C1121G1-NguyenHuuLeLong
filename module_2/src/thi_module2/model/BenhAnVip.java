package thi_module2.model;

public class BenhAnVip extends  BenhAn{
    private String loaiVip;
    private String thoiHanVip;

    public BenhAnVip() {
    }

    public BenhAnVip(int soThuTu, String maBenhAn,String maBenhNhan, String tenBenhNhan, String ngayNhapVien, String ngayRaVien, String lydoNhapVien, String loaiVip, String thoiHanVip) {
        super(soThuTu, maBenhAn,maBenhNhan, tenBenhNhan, ngayNhapVien, ngayRaVien, lydoNhapVien);
        this.loaiVip = loaiVip;
        this.thoiHanVip = thoiHanVip;
    }

    public String getLoaiVip() {
        return loaiVip;
    }

    public void setLoaiVip(String loaiVip) {
        this.loaiVip = loaiVip;
    }

    public String getThoiHanVip() {
        return thoiHanVip;
    }

    public void setThoiHanVip(String thoiHanVip) {
        this.thoiHanVip = thoiHanVip;
    }

    @Override
    public String toString() {
        return super.toString() +
                "loaiVip='" + loaiVip + '\'' +
                ", thoiHanVip='" + thoiHanVip + '\'' +
                "} ";
    }
    public String writeToCsv() {
        return super.writeToCsv()+","+loaiVip+","+thoiHanVip;
    }
}
