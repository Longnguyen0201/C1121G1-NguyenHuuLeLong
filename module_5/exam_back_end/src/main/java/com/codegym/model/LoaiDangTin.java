package com.codegym.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class LoaiDangTin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loai_tin_id")
    private Integer id;
    private String loaiTin;
    @JsonBackReference
    @OneToMany(mappedBy = "loaiDangTin")
    private Set<BaiDang> baiDangs;

    public LoaiDangTin() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoaiTin() {
        return loaiTin;
    }

    public void setLoaiTin(String loaiTin) {
        this.loaiTin = loaiTin;
    }

    public Set<BaiDang> getBaiDangs() {
        return baiDangs;
    }

    public void setBaiDangs(Set<BaiDang> baiDangs) {
        this.baiDangs = baiDangs;
    }
}
