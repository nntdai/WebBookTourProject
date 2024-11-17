package com.example.WebBookTour.service;

import com.example.WebBookTour.entity.Diadiem;
import com.example.WebBookTour.repository.DiaDiemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class DiadiemService {
    private final DiaDiemRepository diaDiemRepository;


    public List<Diadiem> findAll()
    {
        return diaDiemRepository.findAll();
    }

    public Map<Integer,String> getDiaDiem(){
        Map<Integer,String> listDiaDiem = new HashMap<>();
        List<Diadiem> diaDiem = diaDiemRepository.findAll();
        for(Diadiem it : diaDiem){
            listDiaDiem.put(it.getId(), it.getTen());
        }
        return listDiaDiem;
    }
}
