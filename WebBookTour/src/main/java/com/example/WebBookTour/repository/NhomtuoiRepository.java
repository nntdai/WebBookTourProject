package com.example.WebBookTour.repository;

import com.example.WebBookTour.entity.Nhomtuoi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NhomtuoiRepository extends JpaRepository<Nhomtuoi, Integer> {
}