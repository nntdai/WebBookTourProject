package com.example.WebBookTour.service;

import com.example.WebBookTour.dto.DatchotourDto;
import com.example.WebBookTour.entity.Datchotour;
import com.example.WebBookTour.entity.Khachhang;
import com.example.WebBookTour.entity.Tochuctour;
import com.example.WebBookTour.mapper.*;
import com.example.WebBookTour.repository.DatchotourRepository;
import com.example.WebBookTour.repository.KhachhangRepository;
import com.example.WebBookTour.repository.TochuctourRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class datchotour_Service {
    @Autowired
    private final DatchotourRepository datchotourRepository;

    @Autowired
    private final KhachhangRepository khachhangRepository;
    @Autowired
    private TochuctourRepository tochuctourRepository;


    @Autowired
    private DatchotourMapper datchotourMapper;

    @Autowired
    private TourdulichMapper tourdulichMapper;

    @Autowired
    private TochuctourMapper tochuctourMapper;

    @Autowired
    private KhachhangMapper khachhangMapper;
    @Autowired
    private ThongtinhanhkhachMapper thongtinhanhkhachMapper;

    public Page<DatchotourDto> getDatchotour(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "id")); // Thay "id" bằng trường cần sắp xếp
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
        datchotourMapper.linkThongtinkhachhang(datchotourDto, rs, thongtinhanhkhachMapper);
        return datchotourDto;
    }

    public DatchotourDto addDatChoTour(DatchotourDto datchotourDto) {
        Datchotour datchotour = datchotourMapper.toEntity(datchotourDto);
        String soDienThoai = datchotour.getSdtKhachHang().getSoDienThoai();
        Optional<Khachhang> existingKhachhang = khachhangRepository.findBySoDienThoai(soDienThoai);
        Optional<Tochuctour> existingtoChucTour = tochuctourRepository.findById(datchotourDto.getIdToChucTour().getId());
        if (existingtoChucTour.isPresent())
        {
            Tochuctour tochuctour = existingtoChucTour.get();
            tochuctour.setSoChoCon(datchotourDto.getIdToChucTour().getSoChoCon());
            tochuctourRepository.save(tochuctour);
        }
        if (existingKhachhang.isPresent()) {
            datchotour.setSdtKhachHang(existingKhachhang.get());
        } else {
            Khachhang newKhachhang = datchotour.getSdtKhachHang();
            newKhachhang.setDiemTichLuy(0);
            khachhangRepository.save(newKhachhang);
            datchotour.setSdtKhachHang(newKhachhang);
        }
        thongtinhanhkhachMapper.linkDatChoTour(datchotour);
        Datchotour savedDatchotour = datchotourRepository.save(datchotour);
        return datchotourMapper.toDto(savedDatchotour);
    }
//    public Page<DatchotourDto> getSearchDatchotour(int page, int size, String value) {
//        Pageable pageable = PageRequest.of(page, size);
//        Page<Datchotour> ds=datchotourRepository.searchDatchoTourByKeyword(value, pageable);
//        Page<DatchotourDto> datchotourDtos = ds.map(datchotour -> datchotourMapper.toDto(datchotour));
//        if(datchotourDtos == null){
//            System.out.println("Không có dữ liệu");
//        }
//        System.out.println("Có dữ liệu");
//        return datchotourDtos;
//    }
    public Page<DatchotourDto> getSearchDatchotour(int page, int size, String value) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "id"));
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
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "id"));
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
    public List<DatchotourDto> traCuuBangSdt(String soDienThoai) {
        // Lấy danh sách Datchotour theo số điện thoại
        List<Datchotour> ds = datchotourRepository.findBySdtKhachHang_SoDienThoai(soDienThoai);

        // Chuyển đổi sang DatchotourDto
        List<DatchotourDto> datchotourDTOPage = ds.stream().map(datchotour -> {
            // Sử dụng mapper để chuyển đổi và thiết lập các liên kết
            DatchotourDto datchotourDto = datchotourMapper.toDto(datchotour);
            datchotourMapper.linkToChucTour(datchotourDto, datchotour, tochuctourMapper);
            tochuctourMapper.linkTourDuLich(datchotourDto.getIdToChucTour(), datchotour.getIdToChucTour(), tourdulichMapper);
            datchotourMapper.linkKhachHang(datchotourDto, datchotour, khachhangMapper);
            datchotourMapper.linkThongtinkhachhang(datchotourDto, datchotour, thongtinhanhkhachMapper);
            return datchotourDto;
        }).collect(Collectors.toList()); // Thu thập kết quả thành List

        return datchotourDTOPage;
    }

}
