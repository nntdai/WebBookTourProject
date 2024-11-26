package com.example.WebBookTour.service;

import com.example.WebBookTour.dto.NhansuDto;
import com.example.WebBookTour.entity.Nhansu;
import com.example.WebBookTour.mapper.NhansuMapper;
import com.example.WebBookTour.repository.NhansuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NhansuService {
    @Autowired
    private NhansuRepository nhansuRepository;
    @Autowired
    NhansuMapper nhansuMapper;
    public List<NhansuDto> getAll()
    {
        List<Nhansu> nhansu = nhansuRepository.findAll();
        return nhansu.stream().map(nhansuMapper::toDto).collect(Collectors.toList());

    }

}
