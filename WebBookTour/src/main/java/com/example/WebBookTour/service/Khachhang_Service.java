package com.example.WebBookTour.service;

import com.example.WebBookTour.dto.KhachhangDto;
import com.example.WebBookTour.mapper.KhachhangMapper;
import com.example.WebBookTour.repository.KhachhangRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class Khachhang_Service {
    @Autowired
    private final KhachhangRepository khachhangRepository;
    @Autowired
    private final KhachhangMapper khachhangMapper;
    public List<KhachhangDto> getAllKhachhang(){
        List<KhachhangDto> khachhangDto = khachhangRepository.findAll().stream().map(khachhangMapper::toDto).collect(Collectors.toList());
        return khachhangDto;
    }
}
