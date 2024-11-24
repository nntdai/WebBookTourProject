package com.example.WebBookTour.service;

import com.example.WebBookTour.dto.DiadiemDto;
import com.example.WebBookTour.entity.Diadiem;
import com.example.WebBookTour.mapper.DiadiemMapper;
import com.example.WebBookTour.mapper.VungmienMapper;
import com.example.WebBookTour.repository.DiadiemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DiadiemService {

    @Autowired
    private final DiadiemRepository diaDiemRepository;
    @Autowired
    private DiadiemMapper diadiemMapper;
    @Autowired
    private VungmienMapper vungmienMapper;

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
        DiadiemDto diadiemDto=diadiemMapper.toDto(diadiemE);
        diadiemMapper.linkVungmien(diadiemDto, diadiemE, vungmienMapper);
        return diadiemDto;
    }

    public void deleteDiaDiem(int diaDiemId)
    {
        diaDiemRepository.deleteById(diaDiemId);
    }
    public List<DiadiemDto> getAllDiaDiems()
    {
        List<Diadiem> dsDiaDiem = diaDiemRepository.findAll();
        List<DiadiemDto> diadiemDtos = dsDiaDiem.stream()  // Start the stream on the dsDiaDiem list
                .map(diadiem -> {
                    // Ánh xạ Diadiem thành DiadiemDto
                    DiadiemDto diadiemDto = diadiemMapper.toDto(diadiem);

                    // Gọi @AfterMapping để ánh xạ thêm thông tin Vungmien
                    diadiemMapper.linkVungmien(diadiemDto, diadiem, vungmienMapper);

                    return diadiemDto; // Trả về DiadiemDto đã được ánh xạ
                })
                .collect(Collectors.toList());
        return diadiemDtos;
    }

    public Page<DiadiemDto> getDiaDiems(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Diadiem> dsDiaDiem = diaDiemRepository.findAll(pageable);

        Page<DiadiemDto> diadiemDTOPage = dsDiaDiem.map(diadiem -> {
            // Ánh xạ Diadiem thành DiadiemDto
            DiadiemDto diadiemDto = diadiemMapper.toDto(diadiem);

            // Gọi @AfterMapping để ánh xạ thêm thông tin Vungmien
            diadiemMapper.linkVungmien(diadiemDto, diadiem, vungmienMapper);

            return diadiemDto; // Trả về DiadiemDto đã được ánh xạ
        });

        return diadiemDTOPage;
    }


}
