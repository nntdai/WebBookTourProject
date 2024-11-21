package com.example.WebBookTour.service;

import com.example.WebBookTour.dto.DiadiemDto;
import com.example.WebBookTour.entity.Diadiem;
import com.example.WebBookTour.mapper.DiadiemMapper;
import com.example.WebBookTour.repository.diadiemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DiadiemService {

    @Autowired
    private final diadiemRepository diaDiemRepository;
    @Autowired
    private DiadiemMapper diadiemMapper;

//    public List<Diadiem> findAll()
//    {
//        return diaDiemRepository.findAll();
//    }
    public String saveDiaDiem(DiadiemDto diadiemDto)
    {

        Diadiem diadiemE = diadiemMapper.toEntity(diadiemDto);
        diaDiemRepository.save(diadiemE);
        return "Added dia diem";

    }
    public String updateDiaDiem(DiadiemDto diadiemDto)
    {

        Diadiem diadiemE = diadiemMapper.toEntity(diadiemDto);
        Optional<Diadiem> existingDiaDiem = diaDiemRepository.findById(diadiemE.getId());
        if (existingDiaDiem.isPresent()) {
            Diadiem updatedDiaDiem = existingDiaDiem.get();
            updatedDiaDiem.setTen(diadiemE.getTen());
            updatedDiaDiem.setIdVungMien(diadiemE.getIdVungMien());
            diaDiemRepository.save(updatedDiaDiem);
            return "Updated dia diem";
        }
        else{
            return "Dia Diem not found";
        }
    }
    public DiadiemDto findDiaDiemById(int id)
    {
        Diadiem diadiemE = diaDiemRepository.findById(id).get();
        return diadiemMapper.toDto(diadiemE);
    }

    public void deleteDiaDiem(int diaDiemId)
    {
        diaDiemRepository.deleteById(diaDiemId);
    }
    public List<DiadiemDto> getAllDiaDiems()
    {
        List<Diadiem> dsDiaDiem = diaDiemRepository.findAll();
        List<DiadiemDto> diadiemDtos= dsDiaDiem.stream().map(diadiemMapper::toDto).collect(Collectors.toList());
        return diadiemDtos;
    }

    public Page<DiadiemDto> getDiaDiems(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Diadiem> dsDiaDiem = diaDiemRepository.findAll(pageable);
        Page<DiadiemDto> diadiemDTOPage = dsDiaDiem.map(diadiem -> diadiemMapper.toDto(diadiem));
        return diadiemDTOPage;
    }

    public Map<Integer,String> getDiaDiem(){
        Map<Integer,String> listDiaDiem = new HashMap<>();
        List<Diadiem> dsDiaDiem = diaDiemRepository.findAll();
        for(Diadiem it : dsDiaDiem){
            listDiaDiem.put(it.getId(),it.getTen());
        }
        return listDiaDiem;
    }
}
