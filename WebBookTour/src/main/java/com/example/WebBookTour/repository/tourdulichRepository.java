package com.example.WebBookTour.repository;

import com.example.WebBookTour.entity.Tourdulich;
import com.example.WebBookTour.model.tourdulichDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  tourdulichRepository extends JpaRepository<Tourdulich, Integer> {
}
