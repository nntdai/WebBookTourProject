package com.example.WebBookTour.service;

import com.example.WebBookTour.entity.Diadiem;
import com.example.WebBookTour.repository.DiaDiemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DiadiemService {
    private final DiaDiemRepository diaDiemRepository;


    public List<Diadiem> findAll()
    {
        return diaDiemRepository.findAll();
    }
}
