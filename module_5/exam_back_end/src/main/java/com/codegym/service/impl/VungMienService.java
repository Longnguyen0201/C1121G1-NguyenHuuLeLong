package com.codegym.service.impl;

import com.codegym.model.VungMien;
import com.codegym.repository.IVungMienRepository;
import com.codegym.service.IVungMienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VungMienService implements IVungMienService {
    @Autowired
    private IVungMienRepository iVungMienRepository;

    @Override
    public List<VungMien> findAll() {
        return iVungMienRepository.findAll();
    }
}
