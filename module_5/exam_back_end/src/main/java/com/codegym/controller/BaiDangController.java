package com.codegym.controller;

import com.codegym.dto.BaiDangDto;
import com.codegym.model.BaiDang;
import com.codegym.service.IBaiDangService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/baiDang")
@CrossOrigin("*")
public class BaiDangController {
    @Autowired
    private IBaiDangService iBaiDangService;

//    @GetMapping(value = { "/list"})
//    public ResponseEntity<Page<BaiDang>> showList(@PageableDefault(value = 2) Pageable pageable) {
//        Page<BaiDang> baiDangs = iBaiDangService.findAll(pageable);
//        return new ResponseEntity<>(baiDangs, HttpStatus.OK);
//    }

    @PostMapping(value = "/save")
    public ResponseEntity<Map<String,String>> createObject(@Valid @RequestBody BaiDangDto baiDangDto,
                                                          BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            Map<String,String> errorMap = bindingResult.getFieldErrors()
                    .stream().collect(Collectors.toMap(e -> e.getField(), e -> e.getDefaultMessage()));
            return new ResponseEntity<>(errorMap,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        BaiDang baiDang = new BaiDang();
        BeanUtils.copyProperties(baiDangDto, baiDang);
        baiDang.setDanhMuc(baiDangDto.getDanhMuc());
        baiDang.setLoaiDangTin(baiDangDto.getLoaiDangTin());
        baiDang.setPhuongHuong(baiDangDto.getPhuongHuong());
        baiDang.setVungMien(baiDangDto.getVungMien());
        iBaiDangService.save(baiDang);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/edit/{id}")
    public ResponseEntity<BaiDangDto> showEditForm(@PathVariable Integer id) {
        BaiDang baiDang = iBaiDangService.findById(id);
        BaiDangDto baiDangDto = new BaiDangDto();
        BeanUtils.copyProperties(baiDang, baiDangDto);
        baiDangDto.setDanhMuc(baiDang.getDanhMuc());
        baiDangDto.setLoaiDangTin(baiDang.getLoaiDangTin());
        baiDangDto.setPhuongHuong(baiDang.getPhuongHuong());
        baiDangDto.setVungMien(baiDang.getVungMien());
        return new ResponseEntity<>(baiDangDto,HttpStatus.OK);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Map<String,String>> editCustomer(@Valid @RequestBody BaiDangDto baiDangDto,
                                                           BindingResult bindingResult,
                                                           @PathVariable Integer id) {
        if (bindingResult.hasFieldErrors()) {
            Map<String,String> errorMap = bindingResult.getFieldErrors()
                    .stream().collect(Collectors.toMap(e -> e.getField(), e -> e.getDefaultMessage()));
            return new ResponseEntity<>(errorMap,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        BaiDang baiDang = new BaiDang();
        BeanUtils.copyProperties(baiDangDto, baiDang);
        baiDang.setId(id);
        baiDang.setDanhMuc(baiDangDto.getDanhMuc());
        baiDang.setLoaiDangTin(baiDangDto.getLoaiDangTin());
        baiDang.setPhuongHuong(baiDangDto.getPhuongHuong());
        baiDang.setVungMien(baiDangDto.getVungMien());
        iBaiDangService.save(baiDang);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable(value = "id") Integer id) {
        iBaiDangService.remove(id);
        String message = "Xóa thành công";
        return new ResponseEntity<>(HttpStatus.OK) ;
    }

    @GetMapping(value = "/list")
    public ResponseEntity<Page<BaiDang>> searchList(@RequestParam String dienTich,
                                                    @RequestParam String tenHuong,
                                                    @RequestParam String giaTien,
                                                    @PageableDefault(value = 1) Pageable pageable){
        Page<BaiDang> baiDangs = iBaiDangService.searchAll(pageable,dienTich,tenHuong,giaTien);
        return new ResponseEntity<>(baiDangs,HttpStatus.OK);
    }

}
