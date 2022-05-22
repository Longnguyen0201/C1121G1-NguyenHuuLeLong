package com.codegym.service.impl;

import com.codegym.model.DanhMuc;
import com.codegym.repository.IDanhMucRepository;
import com.codegym.service.IDanhMucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DanhMucService implements IDanhMucService {
    @Autowired
    private IDanhMucRepository iDanhMucRepository;

    @Override
    public List<DanhMuc> findAll() {
        return iDanhMucRepository.findAll();
    }
}
