package com.example.WebBookTour.repository;

import com.example.WebBookTour.entity.Datchotour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatchotourRepository extends JpaRepository<Datchotour, Integer> {
}