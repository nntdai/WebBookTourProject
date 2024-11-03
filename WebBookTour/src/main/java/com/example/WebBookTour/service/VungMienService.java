package com.example.WebBookTour.service;

import com.example.WebBookTour.entity.Vungmien;
import com.example.WebBookTour.repository.VungMienRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VungMienService {
    private final VungMienRepository vungMienRepository;
    public List<Vungmien> getAllVungMien(){
        return vungMienRepository.findAll();
    }
}
