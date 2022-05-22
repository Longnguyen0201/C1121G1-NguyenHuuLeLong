package com.codegym.controller;

import com.codegym.model.DanhMuc;
import com.codegym.service.IDanhMucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/danhMuc")
@CrossOrigin("*")
public class DanhMucController {
    @Autowired
    private IDanhMucService iDanhMucService;

    @GetMapping(value = { "/list"})
    public ResponseEntity<List<DanhMuc>> showList() {
        List<DanhMuc> danhMucs = iDanhMucService.findAll();
        return new ResponseEntity<>(danhMucs, HttpStatus.OK);
    }

}
