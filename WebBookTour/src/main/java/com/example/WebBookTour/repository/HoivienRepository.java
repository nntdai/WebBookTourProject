package com.example.WebBookTour.repository;

import com.example.WebBookTour.entity.Hoivien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HoivienRepository extends JpaRepository<Hoivien, Integer> {
}