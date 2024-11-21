package com.example.WebBookTour.service;

import com.example.WebBookTour.entity.Diadiem;
import com.example.WebBookTour.entity.Tourdulich;
import com.example.WebBookTour.exceptions.DataNotFoundException;
import com.example.WebBookTour.dto.TourdulichDto;
import com.example.WebBookTour.repository.diadiemRepository;
import com.example.WebBookTour.repository.tourdulichRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DateTimeException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class tourdulichService {
    @Autowired
    private tourdulichRepository tourRepository;

    @Autowired
    private diadiemRepository diaDiemRepository;


    // Phương thức chuyển đổi từ Tourdulich sang tourdulichDTO
    private TourdulichDto convertToDTO(Tourdulich tour) {
        TourdulichDto tourDTO = new TourdulichDto();
        Diadiem diaDiemKH = tour.getDiaDiemKH();
        Diadiem diaDiemTQ = tour.getDiaDiemThamQuan();
        tourDTO.setTen(tour.getTen());
        tourDTO.setGiaTour(tour.getGiaTour());
        tourDTO.setThoiGian(tour.getThoiGian());
        tourDTO.setPhuongTienDiChuyen(tour.getPhuongTienDiChuyen());
        tourDTO.setDiaDiemKH(diaDiemKH);
        tourDTO.setDiaDiemThamQuan(diaDiemTQ);
        return tourDTO;
    }

    // Lấy tất cả các tour du lịch
    public List<TourdulichDto> getAllTours() {
        return tourRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

}
