package com.codegym.repository;

import com.codegym.model.VungMien;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVungMienRepository extends JpaRepository<VungMien,Integer> {
}
