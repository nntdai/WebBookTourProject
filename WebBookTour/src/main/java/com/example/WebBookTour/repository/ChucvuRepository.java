package com.example.WebBookTour.repository;

import com.example.WebBookTour.entity.Chucvu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChucvuRepository extends JpaRepository<Chucvu, Integer> {
}