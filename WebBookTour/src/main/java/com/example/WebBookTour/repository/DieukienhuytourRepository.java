package com.example.WebBookTour.repository;

import com.example.WebBookTour.entity.Dieukienhuytour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DieukienhuytourRepository extends JpaRepository<Dieukienhuytour, Integer> {
}