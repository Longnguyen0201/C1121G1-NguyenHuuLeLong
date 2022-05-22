package com.codegym.service;

import com.codegym.model.BaiDang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBaiDangService {
    Page<BaiDang> findAll(Pageable pageable);

    void save(BaiDang baiDang);

    BaiDang findById(Integer id);

    void remove(Integer id);

    Page<BaiDang> searchAll(Pageable pageable, String dienTich, String tenHuong, String giaTien);
}
