package com.example.WebBookTour.repository;

import com.example.WebBookTour.entity.Tourdulich;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  TourdulichRepository extends JpaRepository<Tourdulich, Integer> {
}
