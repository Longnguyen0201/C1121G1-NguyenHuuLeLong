package com.codegym.repository;

import com.codegym.model.DanhMuc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDanhMucRepository extends JpaRepository<DanhMuc,Integer> {
}
