package com.example.WebBookTour.repository;

import com.example.WebBookTour.entity.Diadiem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiadiemRepository extends JpaRepository<Diadiem, Integer> {
}
