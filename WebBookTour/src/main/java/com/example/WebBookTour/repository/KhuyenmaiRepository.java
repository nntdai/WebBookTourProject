package com.example.WebBookTour.repository;

import com.example.WebBookTour.entity.Khuyenmai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KhuyenmaiRepository extends JpaRepository<Khuyenmai, String> {
}