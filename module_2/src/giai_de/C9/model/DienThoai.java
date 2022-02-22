package giai_de.C9.model;

public abstract class DienThoai {
    private int idDienthoai;
    private String tenDienThoai;
    private double giaBan;
    private int soLuong;
    private String nhaSanXuat;

    public DienThoai() {
    }

    public DienThoai(int idDienthoai, String tenDienThoai, double giaBan, int soLuong, String nhaSanXuat) {
        this.idDienthoai = idDienthoai;
        this.tenDienThoai = tenDienThoai;
        this.giaBan = giaBan;
        this.soLuong = soLuong;
        this.nhaSanXuat = nhaSanXuat;
    }

    public int getIdDienthoai() {
        return idDienthoai;
    }

    public void setIdDienthoai(int idDienthoai) {
        this.idDienthoai = idDienthoai;
    }

    public String getTenDienThoai() {
        return tenDienThoai;
    }

    public void setTenDienThoai(String tenDienThoai) {
        this.tenDienThoai = tenDienThoai;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getNhaSanXuat() {
        return nhaSanXuat;
    }

    public void setNhaSanXuat(String nhaSanXuat) {
        this.nhaSanXuat = nhaSanXuat;
    }

    @Override
    public String toString() {
        return "DienThoai{" +
                "idDienthoai=" + idDienthoai +
                ", tenDienThoai='" + tenDienThoai + '\'' +
                ", giaBan=" + giaBan +
                ", soLuong=" + soLuong +
                ", nhaSanXuat='" + nhaSanXuat + '\'' +
                '}';
    }

    public String writeToFileCsv(){
        return idDienthoai + "," + tenDienThoai + "," + giaBan + "," + soLuong + "," + nhaSanXuat;
    }
}
