package com.example.WebBookTour.repository;

import com.example.WebBookTour.entity.Vungmien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VungmienRepository extends JpaRepository<Vungmien, Integer> {
  }