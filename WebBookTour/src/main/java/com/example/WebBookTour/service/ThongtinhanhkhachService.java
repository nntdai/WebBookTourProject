package com.example.WebBookTour.service;

import com.example.WebBookTour.dto.ThongtinhanhkhachDto;
import com.example.WebBookTour.entity.Thongtinhanhkhach;
import com.example.WebBookTour.mapper.ThongtinhanhkhachMapper;
import com.example.WebBookTour.repository.ThongtinhanhkhachRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ThongtinhanhkhachService {
    @Autowired
    private final ThongtinhanhkhachRepository thongtinhanhkhachRepository;
    @Autowired
    private final ThongtinhanhkhachMapper thongtinhanhkhachMapper;
    public List<ThongtinhanhkhachDto> GetAllThongtinhanhkhach() {
        return thongtinhanhkhachRepository.findAll().stream().map(thongtinhanhkhachMapper::toDto).collect(Collectors.toList());
    }
//    public List<ThongtinhanhkhachDto> GetThongtinhanhkhachById(int id) {
//        List<Thongtinhanhkhach> dsthongtinhanhkhach=thongtinhanhkhachRepository.findAll();
//        return dsthongtinhanhkhach.stream()
//                .filter(thongtinhanhkhach -> thongtinhanhkhach.getIdDatCho().getId() == id)
//                .map(thongtinhanhkhachMapper::toDto).collect(Collectors.toList());
//    }
}
