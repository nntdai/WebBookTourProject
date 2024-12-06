package com.example.WebBookTour.service;

import com.example.WebBookTour.dto.DatchotourDto;
import com.example.WebBookTour.entity.Datchotour;
import com.example.WebBookTour.mapper.DatchotourMapper;
import com.example.WebBookTour.mapper.KhachhangMapper;
import com.example.WebBookTour.mapper.TochuctourMapper;
import com.example.WebBookTour.mapper.TourdulichMapper;
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

    @Autowired
    private TourdulichMapper tourdulichMapper;

    @Autowired
    private TochuctourMapper tochuctourMapper;

    @Autowired
    private KhachhangMapper khachhangMapper;
    public Page<DatchotourDto> getDatchotour(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Datchotour> ds = datchotourRepository.findAll(pageable);
        Page<DatchotourDto> datchotourDTOPage = ds.map(datchotour ->
        {
            DatchotourDto datchotourDto =datchotourMapper.toDto(datchotour);
            datchotourMapper.linkToChucTour(datchotourDto,datchotour,tochuctourMapper);
            tochuctourMapper.linkTourDuLich(datchotourDto.getIdToChucTour(),datchotour.getIdToChucTour(),tourdulichMapper);
            datchotourMapper.linkKhachHang(datchotourDto,datchotour,khachhangMapper);
           return datchotourDto;
        });
        return datchotourDTOPage;
    }
    public DatchotourDto getDatchotourDto(int id) {
        Datchotour rs=datchotourRepository.findById(id).get();
        DatchotourDto datchotourDto =datchotourMapper.toDto(rs);
        datchotourMapper.linkToChucTour(datchotourDto,rs,tochuctourMapper);
        tochuctourMapper.linkTourDuLich(datchotourDto.getIdToChucTour(),rs.getIdToChucTour(),tourdulichMapper);
        datchotourMapper.linkKhachHang(datchotourDto,rs,khachhangMapper);
        return datchotourDto;
    }
    public Page<DatchotourDto> getSearchDatchotour(int page, int size, String value) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Datchotour> ds=datchotourRepository.searchDatchoTourByKeyword(value, pageable);
        Page<DatchotourDto> datchotourDTOPage = ds.map(datchotour ->
        {
            DatchotourDto datchotourDto =datchotourMapper.toDto(datchotour);
            datchotourMapper.linkToChucTour(datchotourDto,datchotour,tochuctourMapper);
            tochuctourMapper.linkTourDuLich(datchotourDto.getIdToChucTour(),datchotour.getIdToChucTour(),tourdulichMapper);
            datchotourMapper.linkKhachHang(datchotourDto,datchotour,khachhangMapper);
            return datchotourDto;
        });
        if(datchotourDTOPage == null){
            System.out.println("Không có dữ liệu");
        }
        System.out.println("Có dữ liệu");
        return datchotourDTOPage;
    }
    public Page<DatchotourDto> getFilterDatchotour(int page, int size, String matour, String tourdl, String sdt) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Datchotour> ds=datchotourRepository.searchDatchoTour(matour, sdt, tourdl, pageable);
        Page<DatchotourDto> datchotourDTOPage = ds.map(datchotour ->
        {
            DatchotourDto datchotourDto =datchotourMapper.toDto(datchotour);
            datchotourMapper.linkToChucTour(datchotourDto,datchotour,tochuctourMapper);
            tochuctourMapper.linkTourDuLich(datchotourDto.getIdToChucTour(),datchotour.getIdToChucTour(),tourdulichMapper);
            datchotourMapper.linkKhachHang(datchotourDto,datchotour,khachhangMapper);
            return datchotourDto;
        });
        if(datchotourDTOPage == null){
            System.out.println("Không có dữ liệu");
        }
        System.out.println("Có dữ liệu");
        return datchotourDTOPage;
    }

}
