package com.example.WebBookTour.repository;

import com.example.WebBookTour.entity.Huydatchotour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HuydatchotourRepository extends JpaRepository<Huydatchotour, Integer> {
}