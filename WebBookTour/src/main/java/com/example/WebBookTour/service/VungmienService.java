package com.example.WebBookTour.service;

import com.example.WebBookTour.entity.Vungmien;
import com.example.WebBookTour.repository.VungmienRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VungmienService {
    private final VungmienRepository vungMienRepository;
    public List<Vungmien> getAllVungMien(){
        return vungMienRepository.findAll();
    }
}
