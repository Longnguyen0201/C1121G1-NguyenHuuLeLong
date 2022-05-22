package com.codegym.repository;

import com.codegym.model.BaiDang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IBaiDangRepository extends JpaRepository<BaiDang, Integer> {
    @Query(value = "select * from bai_dang " +
            "inner join phuong_huong on phuong_huong.phuong_huong_id = bai_dang.phuong_huong_id " +
            "where dien_tich >=:dienTich  " +
            "and phuong_huong.ten_huong like  concat('%',:tenHuong,'%') " +
            "and gia_tien >=:giaTien ",
            countQuery = "select count(*) from bai_dang " +
                    "inner join phuong_huong on phuong_huong.phuong_huong_id = bai_dang.phuong_huong_id " +
                    "where dien_tich >=:dienTich and phuong_huong.ten_huong like concat('%',:tenHuong,'%') " +
                    "and gia_tien >=:giaTien",nativeQuery = true)
    Page<BaiDang> searchAll( Pageable pageable,@Param("dienTich") String dienTich, @Param("tenHuong") String tenHuong, @Param("giaTien") String giaTien);
}
