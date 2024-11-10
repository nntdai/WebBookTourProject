package com.example.WebBookTour.service;

import com.example.WebBookTour.dto.DiadiemDto;
import com.example.WebBookTour.dto.VungmienDto;
import com.example.WebBookTour.entity.Diadiem;
import com.example.WebBookTour.repository.DiaDiemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DiadiemService {
    private final DiaDiemRepository diaDiemRepository;


    public List<Diadiem> findAll()
    {
        return diaDiemRepository.findAll();
    }
    public Diadiem saveDiaDiem(Diadiem diaDiem)
    {
        return diaDiemRepository.save(diaDiem);
    }
    public void deleteDiaDiem(int diaDiemId)
    {
        diaDiemRepository.deleteById(diaDiemId);
    }
    public Page<DiadiemDto> getDiaDiems(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Diadiem> dsDiaDiem = diaDiemRepository.findAll(pageable);
        Page<DiadiemDto> diadiemDTOPage = dsDiaDiem.map(diadiem -> {
            // Chuyển đối tượng Vungmien thành VungmienDTO
            VungmienDto vungmienDTO = new VungmienDto(
                    diadiem.getIdVungMien().getId(),
                    diadiem.getIdVungMien().getTen()
            );

            // Chuyển Diadiem thành DiadiemDTO
            return new DiadiemDto(
                    diadiem.getId(),
                    diadiem.getTen(),
                    vungmienDTO
            );
        });
        return diadiemDTOPage;
    }
}
