package com.example.WebBookTour.repository;

import com.example.WebBookTour.entity.Tochuctour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TochuctourRepository extends JpaRepository<Tochuctour, Integer> {
}