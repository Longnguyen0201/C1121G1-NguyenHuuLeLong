package com.codegym.service.impl;

import com.codegym.model.PhuongHuong;
import com.codegym.repository.IPhuongHuongRepository;
import com.codegym.service.IPhuongHuongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhuongHuongService implements IPhuongHuongService {
    @Autowired
    private IPhuongHuongRepository iPhuongHuongRepository;

    @Override
    public List<PhuongHuong> findAll() {
        return iPhuongHuongRepository.findAll();
    }
}
