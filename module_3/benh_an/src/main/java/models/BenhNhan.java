package models;

public class BenhNhan {
    private String maBenhNhan;
    private String hoTen;

    public BenhNhan() {
    }

    public BenhNhan(String maBenhNhan, String hoTen) {
        this.maBenhNhan = maBenhNhan;
        this.hoTen = hoTen;
    }

    public String getMaBenhNhan() {
        return maBenhNhan;
    }

    public void setMaBenhNhan(String maBenhNhan) {
        this.maBenhNhan = maBenhNhan;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }
}
