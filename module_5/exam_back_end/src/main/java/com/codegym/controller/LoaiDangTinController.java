package com.codegym.controller;

import com.codegym.model.DanhMuc;
import com.codegym.model.LoaiDangTin;
import com.codegym.service.ILoaiDangTinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/loaiDangTin")
@CrossOrigin("*")
public class LoaiDangTinController {
    @Autowired
    private ILoaiDangTinService iLoaiDangTinService;

    @GetMapping(value = { "/list"})
    public ResponseEntity<List<LoaiDangTin>> showList() {
        List<LoaiDangTin> loaiDangTins = iLoaiDangTinService.findAll();
        return new ResponseEntity<>(loaiDangTins, HttpStatus.OK);
    }
}
