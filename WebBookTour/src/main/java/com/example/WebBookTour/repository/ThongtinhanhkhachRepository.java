package com.example.WebBookTour.repository;

import com.example.WebBookTour.entity.Thongtinhanhkhach;
import com.example.WebBookTour.entity.ThongtinhanhkhachId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThongtinhanhkhachRepository extends JpaRepository<Thongtinhanhkhach, ThongtinhanhkhachId> {
}