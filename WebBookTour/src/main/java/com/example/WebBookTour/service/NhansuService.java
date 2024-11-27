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
    public List<NhansuDto> getAllHDV()
    {
        List<Nhansu> dsnhansu = nhansuRepository.findAll();
        List<NhansuDto> nhansuDto = dsnhansu.stream()
                .filter(nhansu -> nhansu.getTaikhoanadmin() != null && nhansu.getTaikhoanadmin().getId() == 2)
                .map(nhansuMapper::toDto)
                .collect(Collectors.toList());
       return nhansuDto;

    }

}
