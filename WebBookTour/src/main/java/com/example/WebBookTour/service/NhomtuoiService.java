package com.example.WebBookTour.service;

import com.example.WebBookTour.dto.NhomtuoiDto;
import com.example.WebBookTour.entity.Nhomtuoi;
import com.example.WebBookTour.mapper.NhomtuoiMapper;
import com.example.WebBookTour.repository.NhomtuoiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NhomtuoiService {
    @Autowired
    private NhomtuoiRepository nhomtuoiRepository;
    @Autowired
    private NhomtuoiMapper nhomtuoiMapper;
    public List<NhomtuoiDto> getAllNhomTuoi()
    {
        List<Nhomtuoi> nhomtuoiList = nhomtuoiRepository.findAll();
        List<NhomtuoiDto> nhomtuoiDtos = nhomtuoiList.stream().map(nhomtuoiMapper::toDto).collect(Collectors.toList());
        return nhomtuoiDtos;
    }
}
