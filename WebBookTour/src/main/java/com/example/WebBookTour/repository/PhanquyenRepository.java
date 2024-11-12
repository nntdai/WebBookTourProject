package com.example.WebBookTour.repository;

import com.example.WebBookTour.entity.Phanquyen;
import com.example.WebBookTour.entity.PhanquyenId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhanquyenRepository extends JpaRepository<Phanquyen, PhanquyenId> {
}