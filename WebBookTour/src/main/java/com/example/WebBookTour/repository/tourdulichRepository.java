package com.example.WebBookTour.repository;

import com.example.WebBookTour.entity.Tourdulich;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface tourdulichRepository extends JpaRepository<Tourdulich, Integer> {
    public List<Tourdulich> findByAll();
}