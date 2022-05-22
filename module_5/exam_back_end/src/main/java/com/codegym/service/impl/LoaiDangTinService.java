package com.codegym.service.impl;

import com.codegym.model.LoaiDangTin;
import com.codegym.repository.IBaiDangRepository;
import com.codegym.repository.ILoaiDangTinRepository;
import com.codegym.service.ILoaiDangTinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoaiDangTinService implements ILoaiDangTinService {
    @Autowired
    private ILoaiDangTinRepository iLoaiDangTinRepository;

    @Override
    public List<LoaiDangTin> findAll() {
        return iLoaiDangTinRepository.findAll();
    }
}
