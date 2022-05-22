package com.codegym.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class PhuongHuong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "phuong_huong_id")
    private Integer id;
    private String tenHuong;

    @JsonBackReference
    @OneToMany(mappedBy = "phuongHuong")
    private Set<BaiDang> baiDangs;

    public PhuongHuong() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenHuong() {
        return tenHuong;
    }

    public void setTenHuong(String tenHuong) {
        this.tenHuong = tenHuong;
    }

    public Set<BaiDang> getBaiDangs() {
        return baiDangs;
    }

    public void setBaiDangs(Set<BaiDang> baiDangs) {
        this.baiDangs = baiDangs;
    }
}
