package com.example.WebBookTour.repository;

import com.example.WebBookTour.entity.Khachhang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface KhachhangRepository extends JpaRepository<Khachhang, String> {
    Optional<Khachhang> findBySoDienThoai(String soDienThoai);
}