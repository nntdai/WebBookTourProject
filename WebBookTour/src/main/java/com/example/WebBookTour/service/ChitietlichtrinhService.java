package com.example.WebBookTour.service;

import com.example.WebBookTour.dto.ChitietlichtrinhDto;
import com.example.WebBookTour.entity.Chitietlichtrinh;
import com.example.WebBookTour.entity.Tourdulich;
import com.example.WebBookTour.mapper.ChitietlichtrinhMapper;
import com.example.WebBookTour.repository.ChitietlichtrinhRepository;
import com.example.WebBookTour.repository.TourdulichRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChitietlichtrinhService {

    @Autowired
    private ChitietlichtrinhRepository chitietlichtrinhRepository;

    @Autowired
    private TourdulichRepository tourdulichRepository;

    @Autowired
    private ChitietlichtrinhMapper chitietlichtrinhMapper;

    public List<Chitietlichtrinh> saveListLichTrinh(List<ChitietlichtrinhDto> chitietlichtrinhDtoList)
    {
        List<Chitietlichtrinh> chitietlichtrinhList = chitietlichtrinhMapper.toEntityList(chitietlichtrinhDtoList);
        for (Chitietlichtrinh chitietlichtrinh : chitietlichtrinhList) {
            if (chitietlichtrinh.getId().getIdTour() != null) {
                Tourdulich tourdulich = tourdulichRepository.findById(chitietlichtrinh.getId().getIdTour())
                        .orElseThrow(() -> new RuntimeException("Tour not found"));
                chitietlichtrinh.setIdTour(tourdulich); // Gán đúng đối tượng Tourdulich
            }
        }

        return chitietlichtrinhRepository.saveAll(chitietlichtrinhList);

    }
}
