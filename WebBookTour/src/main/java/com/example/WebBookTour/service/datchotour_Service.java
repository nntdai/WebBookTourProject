package com.example.WebBookTour.service;

import com.example.WebBookTour.dto.DatchotourDto;
import com.example.WebBookTour.entity.Datchotour;
import com.example.WebBookTour.mapper.DatchotourMapper;
import com.example.WebBookTour.repository.DatchotourRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class datchotour_Service {
    @Autowired
    private final DatchotourRepository datchotourRepository;
    @Autowired
    private DatchotourMapper datchotourMapper;
    public Page<DatchotourDto> getDatchotour(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Datchotour> ds = datchotourRepository.findAll(pageable);
        Page<DatchotourDto> datchotourDTO = ds.map(datchotour -> datchotourMapper.toDto(datchotour));
        return datchotourDTO;
    }
    public DatchotourDto getDatchotourDto(int id) {
        Datchotour rs=datchotourRepository.findById(id).get();
        return datchotourMapper.toDto(rs);
    }
    public Page<DatchotourDto> getSearchDatchotour(int page, int size, String value) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Datchotour> ds=datchotourRepository.searchDatchoTourByKeyword(value, pageable);
        Page<DatchotourDto> datchotourDtos = ds.map(datchotour -> datchotourMapper.toDto(datchotour));
        if(datchotourDtos == null){
            System.out.println("Không có dữ liệu");
        }
        System.out.println("Có dữ liệu");
        return datchotourDtos;
    }
}
