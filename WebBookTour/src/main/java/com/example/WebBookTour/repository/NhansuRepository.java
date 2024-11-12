package com.example.WebBookTour.repository;

import com.example.WebBookTour.entity.Nhansu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NhansuRepository extends JpaRepository<Nhansu, Integer> {
}