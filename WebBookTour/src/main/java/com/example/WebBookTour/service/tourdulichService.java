package com.example.WebBookTour.service;

import com.example.WebBookTour.dto.DiadiemDto;
import com.example.WebBookTour.entity.Diadiem;
import com.example.WebBookTour.entity.Tourdulich;
import com.example.WebBookTour.exceptions.DataNotFoundException;
import com.example.WebBookTour.dto.TourdulichDto;
import com.example.WebBookTour.repository.TourdulichRepository;
import com.example.WebBookTour.repository.DiaDiemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DateTimeException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class tourdulichService {
    @Autowired
    private TourdulichRepository tourRepository;

    @Autowired
    private DiaDiemRepository diaDiemRepository;


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

    // Thêm một tour mới
    public Tourdulich addTour(TourdulichDto tour) throws DataNotFoundException {
        Diadiem existingDiaDiemKhoiHanh = diaDiemRepository
                .findById(tour.getDiaDiemKH().getId())
                .orElseThrow(() ->
                        new DataNotFoundException(
                                "cannot find diaDiemKhoiHanh with id: " + tour.getDiaDiemKH().getId()));

        Diadiem existingDiaDiemThamQuan = diaDiemRepository
                .findById(tour.getDiaDiemThamQuan().getId())
                .orElseThrow(() ->
                        new DataNotFoundException(
                                "cannot find diaDiemThamQuan with id: " + tour.getDiaDiemThamQuan().getId()));

        Tourdulich newTourdulich = Tourdulich.builder()
                .ten(tour.getTen())
                .giaTour(tour.getGiaTour())
                .thoiGian(tour.getThoiGian())
                .phuongTienDiChuyen(tour.getPhuongTienDiChuyen())
                .build();
        newTourdulich.setDiaDiemKH(existingDiaDiemKhoiHanh);
        newTourdulich.setDiaDiemThamQuan(existingDiaDiemThamQuan);
        return tourRepository.save(newTourdulich);
    }
}
