package com.example.WebBookTour.repository;

import com.example.WebBookTour.entity.Khachhang;
import com.example.WebBookTour.entity.Tochuctour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface TochuctourRepository extends JpaRepository<Tochuctour, Integer> {
    Optional<Tochuctour> findById(Integer id);
    Optional<Tochuctour> findByNgayKH(LocalDate ngayKH);
}