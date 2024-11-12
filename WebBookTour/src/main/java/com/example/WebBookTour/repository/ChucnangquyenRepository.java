package com.example.WebBookTour.repository;

import com.example.WebBookTour.entity.Chucnangquyen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChucnangquyenRepository extends JpaRepository<Chucnangquyen, Integer> {
}