package com.codegym.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class VungMien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vung_mien_id")
    private Integer id;
    private String tenVungMien;

    @JsonBackReference
    @OneToMany(mappedBy = "vungMien")
    private Set<BaiDang> baiDangs;

    public VungMien() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenVungMien() {
        return tenVungMien;
    }

    public void setTenVungMien(String tenVungMien) {
        this.tenVungMien = tenVungMien;
    }

    public Set<BaiDang> getBaiDangs() {
        return baiDangs;
    }

    public void setBaiDangs(Set<BaiDang> baiDangs) {
        this.baiDangs = baiDangs;
    }
}
