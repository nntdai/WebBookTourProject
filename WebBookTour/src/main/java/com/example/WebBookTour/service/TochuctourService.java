package com.example.WebBookTour.service;

import com.example.WebBookTour.dto.TochuctourDto;
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

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

@Service
public class TochuctourService {
    @Autowired
    private TochuctourRepository tochuctourRepository;

    @Autowired
    private TochuctourMapper tochuctourMapper;

    @Autowired
    private TourdulichMapper tourdulichMapper;

//    public String addToChucTour(TochuctourDto tochuctourDto) {
//        // Chuyển đổi Instant thành LocalDate (chỉ lấy ngày, không tính thời gian)
//        Instant ngayKHInstant = tochuctourDto.getNgayKH();
//        LocalDate ngayKHLocalDate = ngayKHInstant.atZone(ZoneId.systemDefault()).toLocalDate();
//        System.out.println(ngayKHLocalDate);
//        // Kiểm tra xem có tổ chức tour nào với ngày khởi hành trùng không
//        boolean isExist = tochuctourRepository.existsByIdTourDuLich_IdAndNgayKH(
//                tochuctourDto.getIdTourDuLich().getId(),
//                ngayKHLocalDate // So sánh chỉ ngày
//        );
//
//        if (isExist) {
//            return "Ngày khởi hành đã tồn tại cho tour này!";
//        }
//
//        // Nếu không trùng, chuyển đổi DTO thành entity
//        Tochuctour tochuctour = tochuctourMapper.toEntity(tochuctourDto);
//
//        tochuctourRepository.save(tochuctour);
//
//        // Trả về thông báo thành công
//        return "Tổ chức 1 tour mới thành công!";
//    }

    public String addToChucTour(TochuctourDto tochuctourDto) {
        Tochuctour tochuctour = tochuctourMapper.toEntity(tochuctourDto);
        tochuctourRepository.save(tochuctour);
        return "Tổ chức 1 tour mới thành công !";
    }
    public TochuctourDto getToChucTourById(int i) {
        Tochuctour tochuctour = tochuctourRepository.findById(i).orElse(null);
        TochuctourDto tochuctourDto  = tochuctourMapper.toDto(tochuctour);
        tochuctourMapper.linkTourDuLich(tochuctourDto,tochuctour,tourdulichMapper);
        return tochuctourDto;
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

        // Tính toán lại tổng số phần tử đã lọc
        long filteredTotalElements = filteredDtos.size();

        // Chuyển kết quả đã lọc thành Page
        return new PageImpl<>(filteredDtos, pageable, filteredTotalElements);
    }
    public List<TochuctourDto> getAllListTochuctours(int idTour) {
        List<Tochuctour> dsToChucTour = tochuctourRepository.findAll();

        // Map và lọc kết quả
        return dsToChucTour.stream()
                .filter(tochuctour -> tochuctour.getIdTourDuLich().getId() == idTour)
                .map(tochuctour -> {
                    TochuctourDto tochuctourDto = tochuctourMapper.toDto(tochuctour);
                    tochuctourMapper.linkTourDuLich(tochuctourDto, tochuctour, tourdulichMapper);
                    return tochuctourDto;
                })
                .toList();
    }
}
