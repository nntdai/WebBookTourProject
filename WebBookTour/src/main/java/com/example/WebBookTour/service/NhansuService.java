package com.example.WebBookTour.service;

import com.example.WebBookTour.dto.DatchotourDto;
import com.example.WebBookTour.dto.NhansuDto;
import com.example.WebBookTour.entity.Datchotour;
import com.example.WebBookTour.entity.Nhansu;
import com.example.WebBookTour.mapper.NhansuMapper;
import com.example.WebBookTour.repository.NhansuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NhansuService {
    @Autowired
    private NhansuRepository nhansuRepository;
    @Autowired
    NhansuMapper nhansuMapper;
    public List<NhansuDto> getAllHDV()
    {
        List<Nhansu> dsnhansu = nhansuRepository.findAll();
        List<NhansuDto> nhansuDto = dsnhansu.stream()
                .filter(nhansu -> nhansu.getTaikhoanadmin() != null && nhansu.getTaikhoanadmin().getId() == 2)
                .map(nhansuMapper::toDto)
                .collect(Collectors.toList());
       return nhansuDto;

    }
    public Page<NhansuDto> getNhanSu(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Nhansu> ds = nhansuRepository.findAll(pageable);
        Page<NhansuDto> nhansuDTOPage = ds.map(nhansu ->
        {
            NhansuDto nhansuDto =nhansuMapper.toDto(nhansu);
            return nhansuDto;
        });
        return nhansuDTOPage;
    }
    public NhansuDto getNhansuById(int id) {
        Nhansu nhansu = nhansuRepository.findById(id).get();
        return nhansuMapper.toDto(nhansu);
    }
    public String updateNhansu(NhansuDto nhansuDto) {
        Nhansu nhansuE = nhansuMapper.toEntity(nhansuDto);
        Optional<Nhansu> nhansuOptional = nhansuRepository.findById(nhansuE.getId());
        if(nhansuOptional.isPresent()) {
            Nhansu updatenhansu = nhansuOptional.get();
            updatenhansu.setTen(nhansuE.getTen());
            updatenhansu.setDiaChi(nhansuE.getDiaChi());
            updatenhansu.setCmnd(nhansuE.getCmnd());
            updatenhansu.setSoDienThoai(nhansuE.getSoDienThoai());
            updatenhansu.setEmail(nhansuE.getEmail());
            updatenhansu.setHinhAnh(nhansuE.getHinhAnh());
            nhansuRepository.save(updatenhansu);
            return "Updated Successfully";
        }else{
            return "Nhansu not found";
        }
    }
}
