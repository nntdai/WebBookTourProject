package com.example.WebBookTour.service;

import com.example.WebBookTour.entity.Tourdulich;
import com.example.WebBookTour.model.tourdulichDTO;
import com.example.WebBookTour.repository.TourdulichRepository;
import com.example.WebBookTour.repository.DiadiemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class tourdulichService {
    @Autowired
    private TourdulichRepository tourRepository;

    @Autowired
    private DiadiemRepository ddRepository;


    // Phương thức chuyển đổi từ Tourdulich sang tourdulichDTO
    private tourdulichDTO convertToDTO(Tourdulich tour) {
        tourdulichDTO tourDTO = new tourdulichDTO();
        tourDTO.setTen(tour.getTen());
        tourDTO.setGiaTien(tour.getGiaTour());
        tourDTO.setThoiGian(tour.getThoiGian());
        tourDTO.setPhuongTienDiChuyen(tour.getPhuongTienDiChuyen());
        tourDTO.setDiadiemkhoiHanh(tour.getDiaDiemKH().getTen());
        tourDTO.setDiaDiemThamQuan(tour.getDiaDiemThamQuan().getTen());
        return tourDTO;
    }

    // Lấy tất cả các tour du lịch
    public List<tourdulichDTO> getAllTours() {
        return tourRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Thêm một tour mới
//    public Tourdulich addTour(tourdulichDTO tour) throws DataNotFoundException {
//        ddRepository.findById(tour.getDiadiemkhoiHanh())
//                .orElseThrow(() ->
//                        new DataNotFoundException(
//                                "Cannot find diadiem with id: " + tour.getDiadiemkhoiHanh()
//                        ));
//
//
////        return tourRepository.save(tour);
//    }

    // Cập nhật một tour
//    public Optional<tourdulichDTO> updateTour(Long id, Tourdulich updatedTour) {
//        return tourRepository.findById(id).map(tour -> {
//            tour.setTen(updatedTour.getTen());
//            tour.setGiaTour(updatedTour.getGiaTour());
//            tour.setThoiGian(updatedTour.getThoiGian());
//            tour.setPhuongTienDiChuyen(updatedTour.getPhuongTienDiChuyen());
//            tour.setDiaDiemKH(updatedTour.getdiadiemkhoiHanh());
//            tour.setDiaDiemThamQuan(updatedTour.getDiaDiemThamQuan());
//            return tourRepository.save(tour);
//        });
//    }

    // Xóa một tour
//    public boolean deleteTour(Long id) {
//        if (tourRepository.existsById(id)) {
//            tourRepository.deleteById(id);
//            return true;
//        }
//        return false;
//    }
}
