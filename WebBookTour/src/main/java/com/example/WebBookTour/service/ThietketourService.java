package com.example.WebBookTour.service;

import com.example.WebBookTour.dto.TourdulichDto;
import com.example.WebBookTour.entity.Tourdulich;
import com.example.WebBookTour.mapper.ChitietlichtrinhMapper;
import com.example.WebBookTour.repository.TourdulichRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.WebBookTour.mapper.TourdulichMapper;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ThietketourService {
    @Autowired
    TourdulichRepository tourdulichRepository;
    @Autowired
    private TourdulichMapper TourdulichMapper;
    @Autowired
    private ChitietlichtrinhMapper ChitietlichtrinhMapper;
    public Page<TourdulichDto> getTourDuLich(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Tourdulich> dsTour = tourdulichRepository.findAll(pageable);
        Page<TourdulichDto> tourdulichDtoPage = dsTour.map(tourdulich ->
                {
                    TourdulichDto tourdulichDto = TourdulichMapper.toDto(tourdulich);
                    TourdulichMapper.linkChitietlichtrinhs(tourdulichDto,tourdulich,ChitietlichtrinhMapper);
                    return tourdulichDto;
                }
        );

        return tourdulichDtoPage;
    }
    public List<Tourdulich> getAllTourDuLich() {
        return tourdulichRepository.findAll();
    }
    public String addTourDulich(TourdulichDto tourdulichDto) {
        Tourdulich tourdulich = TourdulichMapper.toEntity(tourdulichDto);
        ChitietlichtrinhMapper.linkTourDuLich(tourdulich);
//        int TourID= tourdulichRepository.save(tourdulich).getId();
         tourdulichRepository.save(tourdulich);
        return "Thành Công";
    }
}
