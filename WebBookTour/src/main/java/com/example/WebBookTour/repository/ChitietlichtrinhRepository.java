package com.example.WebBookTour.repository;

import com.example.WebBookTour.entity.Chitietlichtrinh;
import com.example.WebBookTour.entity.ChitietlichtrinhId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChitietlichtrinhRepository extends JpaRepository<Chitietlichtrinh, ChitietlichtrinhId> {
}