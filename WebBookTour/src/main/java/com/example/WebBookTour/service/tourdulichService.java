package com.example.WebBookTour.service;


import com.example.WebBookTour.entity.Diadiem;
import com.example.WebBookTour.entity.Tourdulich;
import com.example.WebBookTour.dto.TourdulichDto;
import com.example.WebBookTour.repository.diadiemRepository;
import com.example.WebBookTour.repository.tourdulichRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

import java.util.stream.Collectors;

@Service
public class tourdulichService {

    @Autowired
    private EntityManager entityManager;

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

    public List<TourdulichDto> getByFind(Integer diaDiemThamQuan,Integer diaDiemKhoiHanh,Integer priceTo,Integer priceForm){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tourdulich> cq = cb.createQuery(Tourdulich.class);
        Root<Tourdulich> root = cq.from(Tourdulich.class);

        List<Predicate> predicates = new ArrayList<>();

        if (diaDiemThamQuan != null) {
            Diadiem diaDiem = diaDiemRepository.findDiadiemById(diaDiemThamQuan);
            predicates.add(cb.equal(root.get("diaDiemThamQuan"), diaDiem));
        }
        if (diaDiemKhoiHanh != null) {
            Diadiem diaDiem = diaDiemRepository.findDiadiemById(diaDiemKhoiHanh);
            predicates.add(cb.equal(root.get("diaDiemKH"), diaDiem));
        }
        if (priceTo != null) {
            predicates.add(cb.lessThan(root.get("giaTour"), priceTo));
        }
        if (priceForm != null) {
            predicates.add(cb.greaterThan(root.get("giaTour"), priceForm));
        }

        cq.where(predicates.toArray(new Predicate[0]));

        List<Tourdulich> listTourDuLich = entityManager.createQuery(cq).getResultList();

        List<TourdulichDto> tourDuLichDTOList = new ArrayList<>();
        for(Tourdulich it : listTourDuLich){
            tourDuLichDTOList.add(convertToDTO(it));
        }
        return tourDuLichDTOList;
    }

}
