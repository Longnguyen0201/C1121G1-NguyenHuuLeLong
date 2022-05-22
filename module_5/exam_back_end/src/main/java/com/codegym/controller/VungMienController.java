package com.codegym.controller;

import com.codegym.model.PhuongHuong;
import com.codegym.model.VungMien;
import com.codegym.service.IVungMienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/vungMien")
@CrossOrigin("*")
public class VungMienController {
    @Autowired
    private IVungMienService iVungMienService;

    @GetMapping(value = { "/list"})
    public ResponseEntity<List<VungMien>> showList() {
        List<VungMien> vungMiens = iVungMienService.findAll();
        return new ResponseEntity<>(vungMiens, HttpStatus.OK);
    }


}
