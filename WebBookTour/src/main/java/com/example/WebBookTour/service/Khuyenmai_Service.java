package com.example.WebBookTour.service;

import com.example.WebBookTour.dto.KhuyenmaiDto;
import com.example.WebBookTour.mapper.KhuyenmaiMapper;
import com.example.WebBookTour.repository.KhuyenmaiRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class Khuyenmai_Service {
    @Autowired
    private final KhuyenmaiRepository khuyenmaiRepository;
    @Autowired
    private final KhuyenmaiMapper khuyenmaiMapper;
    public List<KhuyenmaiDto> getAllKhuyenmai(){
        List<KhuyenmaiDto> khuyenmaiDto= khuyenmaiRepository.findAll().stream().map(khuyenmaiMapper::toDto).collect(Collectors.toList());
        return khuyenmaiDto;
    }
}
