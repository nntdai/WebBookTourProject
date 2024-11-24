package com.example.WebBookTour.service;

import com.example.WebBookTour.dto.VungmienDto;
import com.example.WebBookTour.entity.Vungmien;
import com.example.WebBookTour.mapper.VungmienMapper;
import com.example.WebBookTour.mapper.DiadiemMapper;
import com.example.WebBookTour.repository.VungmienRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VungmienService {
    @Autowired
    private final VungmienRepository vungMienRepository;
    @Autowired
    private final VungmienMapper vungmienMapper;
    @Autowired
    private final DiadiemMapper diadiemMapper;

    public List<VungmienDto> getAllVungMien(){

        List<VungmienDto> vungmienDtos = vungMienRepository.findAll().stream()
                .map(vungmien -> {
                    // Ánh xạ Vungmien thành VungmienDto
                    VungmienDto vungmienDto = vungmienMapper.toDto(vungmien);

                    // Gọi phương thức để ánh xạ thông tin Diadiem liên quan
                    vungmienMapper.linkDiadiems(vungmienDto, vungmien, diadiemMapper);

                    return vungmienDto;  // Trả về VungmienDto đã được ánh xạ
                })
                .collect(Collectors.toList());
        return vungmienDtos;
    }

 
}
