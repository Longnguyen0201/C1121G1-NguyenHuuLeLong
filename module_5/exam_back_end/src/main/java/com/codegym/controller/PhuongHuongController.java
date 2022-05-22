package com.codegym.controller;

import com.codegym.model.LoaiDangTin;
import com.codegym.model.PhuongHuong;
import com.codegym.service.IBaiDangService;
import com.codegym.service.IPhuongHuongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/phuongHuong")
@CrossOrigin("*")
public class PhuongHuongController {
    @Autowired
    private IPhuongHuongService iPhuongHuongService;

    @GetMapping(value = { "/list"})
    public ResponseEntity<List<PhuongHuong>> showList() {
        List<PhuongHuong> phuongHuongs = iPhuongHuongService.findAll();
        return new ResponseEntity<>(phuongHuongs, HttpStatus.OK);
    }

}
