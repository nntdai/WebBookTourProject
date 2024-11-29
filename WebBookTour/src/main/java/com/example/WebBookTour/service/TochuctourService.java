package com.example.WebBookTour.service;

import com.example.WebBookTour.dto.TochuctourDto;
import com.example.WebBookTour.dto.TourdulichDto;
import com.example.WebBookTour.entity.Tochuctour;
import com.example.WebBookTour.entity.Tourdulich;
import com.example.WebBookTour.mapper.TochuctourMapper;
import com.example.WebBookTour.mapper.TourdulichMapper;
import com.example.WebBookTour.repository.TochuctourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TochuctourService {
    @Autowired
    private TochuctourRepository tochuctourRepository;

    @Autowired
    private TochuctourMapper tochuctourMapper;

    @Autowired
    private TourdulichMapper tourdulichMapper;

    public String addToChucTour(TochuctourDto tochuctourDto) {
        Tochuctour tochuctour = tochuctourMapper.toEntity(tochuctourDto);
        tochuctourRepository.save(tochuctour);
        return "Tổ chức 1 tour mới thành công !";
    }

    public Page<TochuctourDto> getAllTochuctours(int page, int size, int idTour) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Tochuctour> dsToChucTour = tochuctourRepository.findAll(pageable);

        // Map và lọc kết quả
        List<TochuctourDto> filteredDtos = dsToChucTour.getContent().stream()
                .filter(tochuctour -> tochuctour.getIdTourDuLich().getId() == idTour)
                .map(tochuctour -> {
                    TochuctourDto tochuctourDto = tochuctourMapper.toDto(tochuctour);
                    tochuctourMapper.linkTourDuLich(tochuctourDto, tochuctour, tourdulichMapper);
                    return tochuctourDto;
                })
                .toList();

        // Chuyển kết quả đã lọc thành Page
        return new PageImpl<>(filteredDtos, pageable, dsToChucTour.getTotalElements());
    }
}
