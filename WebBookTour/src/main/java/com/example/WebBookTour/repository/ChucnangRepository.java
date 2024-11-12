package com.example.WebBookTour.repository;

import com.example.WebBookTour.entity.Chucnang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChucnangRepository extends JpaRepository<Chucnang, Integer> {
}