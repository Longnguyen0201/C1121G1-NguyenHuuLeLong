package com.codegym.service.impl;

import com.codegym.model.BaiDang;
import com.codegym.repository.IBaiDangRepository;
import com.codegym.service.IBaiDangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BaiDangService implements IBaiDangService {
    @Autowired
    private IBaiDangRepository iBaiDangRepository;

    @Override
    public Page<BaiDang> findAll(Pageable pageable) {
        return iBaiDangRepository.findAll(pageable);
    }

    @Override
    public void save(BaiDang baiDang) {
        iBaiDangRepository.save(baiDang);
    }

    @Override
    public BaiDang findById(Integer id) {
        return iBaiDangRepository.findById(id).orElse(null);
    }

    @Override
    public void remove(Integer id) {
        iBaiDangRepository.deleteById(id);
    }

    @Override
    public Page<BaiDang> searchAll( Pageable pageable, String dienTich, String tenHuong, String giaTien) {
        return iBaiDangRepository.searchAll(pageable,dienTich,tenHuong,giaTien);
    }
}
