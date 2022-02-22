package giai_de.C9.model;

public class DienThoaiChinhHang extends DienThoai {
private String thoiGianBaoHanh;
private String phamViBaoHanh;

    public DienThoaiChinhHang() {
    }

    public DienThoaiChinhHang(int idDienthoai, String tenDienThoai, double giaBan, int soLuong, String nhaSanXuat, String thoiGianBaoHanh, String phamViBaoHanh) {
        super(idDienthoai, tenDienThoai, giaBan, soLuong, nhaSanXuat);
        this.thoiGianBaoHanh = thoiGianBaoHanh;
        this.phamViBaoHanh = phamViBaoHanh;
    }

    public String getThoiGianBaoHanh() {
        return thoiGianBaoHanh;
    }

    public void setThoiGianBaoHanh(String thoiGianBaoHanh) {
        this.thoiGianBaoHanh = thoiGianBaoHanh;
    }

    public String getPhamViBaoHanh() {
        return phamViBaoHanh;
    }

    public void setPhamViBaoHanh(String phamViBaoHanh) {
        this.phamViBaoHanh = phamViBaoHanh;
    }

    @Override
    public String toString() {
        return super.toString()+
                "thoiGianBaoHanh='" + thoiGianBaoHanh + '\'' +
                ", phamViBaoHanh='" + phamViBaoHanh + '\'' +
                "} " ;
    }
    public String writeToFileCsv(){
        return super.writeToFileCsv()+","+ thoiGianBaoHanh+","+phamViBaoHanh;
    }
}
