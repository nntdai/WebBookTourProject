package com.example.WebBookTour.repository;

import com.example.WebBookTour.entity.Diadiem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DiaDiemRepository extends JpaRepository<Diadiem, Integer> {

}
