package com.codegym.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class DanhMuc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "danh_muc_id")
    private Integer id;
    private String tenDanhMuc;

    @JsonBackReference
    @OneToMany(mappedBy = "danhMuc")
    private Set<BaiDang> baiDangs;


    public DanhMuc() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenDanhMuc() {
        return tenDanhMuc;
    }

    public void setTenDanhMuc(String tenDanhMuc) {
        this.tenDanhMuc = tenDanhMuc;
    }

    public Set<BaiDang> getBaiDangs() {
        return baiDangs;
    }

    public void setBaiDangs(Set<BaiDang> baiDangs) {
        this.baiDangs = baiDangs;
    }
}
