package com.codegym.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class BaiDang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private String tieuDe;
    @NotNull
    private String noiDung;
    @NotNull
    private Double dienTich;
    @NotNull
    private Double giaTien;
    @NotNull
    private String diaChi;
    @NotNull
    private Integer tinhTrang;
    @NotNull
    private Integer doiTuong;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "danh_muc_id", referencedColumnName = "danh_muc_id")
    private DanhMuc danhMuc;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "loai_tin_id", referencedColumnName = "loai_tin_id")
    private LoaiDangTin loaiDangTin;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "phuong_huong_id", referencedColumnName = "phuong_huong_id")
    private PhuongHuong phuongHuong;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "vung_mien_id", referencedColumnName = "vung_mien_id")
    private VungMien vungMien;

    public BaiDang() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public Double getDienTich() {
        return dienTich;
    }

    public void setDienTich(Double dienTich) {
        this.dienTich = dienTich;
    }

    public Double getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(Double giaTien) {
        this.giaTien = giaTien;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public Integer getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(Integer tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public Integer getDoiTuong() {
        return doiTuong;
    }

    public void setDoiTuong(Integer doiTuong) {
        this.doiTuong = doiTuong;
    }

    public DanhMuc getDanhMuc() {
        return danhMuc;
    }

    public void setDanhMuc(DanhMuc danhMuc) {
        this.danhMuc = danhMuc;
    }

    public LoaiDangTin getLoaiDangTin() {
        return loaiDangTin;
    }

    public void setLoaiDangTin(LoaiDangTin loaiDangTin) {
        this.loaiDangTin = loaiDangTin;
    }

    public PhuongHuong getPhuongHuong() {
        return phuongHuong;
    }

    public void setPhuongHuong(PhuongHuong phuongHuong) {
        this.phuongHuong = phuongHuong;
    }

    public VungMien getVungMien() {
        return vungMien;
    }

    public void setVungMien(VungMien vungMien) {
        this.vungMien = vungMien;
    }
}
