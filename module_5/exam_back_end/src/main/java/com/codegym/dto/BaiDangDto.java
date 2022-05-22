package com.codegym.dto;

import com.codegym.model.DanhMuc;
import com.codegym.model.LoaiDangTin;
import com.codegym.model.PhuongHuong;
import com.codegym.model.VungMien;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class BaiDangDto {


    private Integer id;
    @NotEmpty(message = "Không được bỏ trống ")
    private String tieuDe;
    @NotEmpty(message = "Không được bỏ trống ")
    private String noiDung;
    @NotNull(message = "Không được bỏ trống ")
    @Min(value = 20,message = "diện tích phải lớn hơn 20m.")
    private Double dienTich;
    @NotNull(message = "Không được bỏ trống ")
    @Min(value = 10000000,message = "Giá tiền phải lớn hơn 100.000.000VND.")
    private Double giaTien;
    @NotEmpty(message = "Không được bỏ trống ")
    private String diaChi;
    @NotNull(message = "Không được bỏ trống ")
    private Integer tinhTrang;
    @NotNull(message = "Không được bỏ trống ")
    private Integer doiTuong;

    private DanhMuc danhMuc;

    private LoaiDangTin loaiDangTin;

    private PhuongHuong phuongHuong;


    private VungMien vungMien;

    public BaiDangDto() {
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
