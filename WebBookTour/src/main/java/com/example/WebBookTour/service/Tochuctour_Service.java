package com.example.WebBookTour.service;

import com.example.WebBookTour.dto.TochuctourDto;
import com.example.WebBookTour.entity.Tochuctour;
import com.example.WebBookTour.mapper.TochuctourMapper;
import com.example.WebBookTour.repository.TochuctourRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class Tochuctour_Service {
    @Autowired
    private final TochuctourRepository tochuctourRepository;
    @Autowired
    private final TochuctourMapper tochuctourMapper;
    public List<TochuctourDto> getAllTochuctour(){
        List<TochuctourDto> tochuctourDtos = tochuctourRepository.findAll().stream().map(tochuctourMapper::toDto).collect(Collectors.toList());
        return tochuctourDtos;
    }
}
