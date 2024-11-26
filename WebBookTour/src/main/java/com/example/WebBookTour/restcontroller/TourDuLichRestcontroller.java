package com.example.WebBookTour.restcontroller;

import com.example.WebBookTour.dto.ChitietlichtrinhDto;

import com.example.WebBookTour.dto.TourdulichDto;
import com.example.WebBookTour.entity.Tourdulich;
import com.example.WebBookTour.service.ChitietlichtrinhService;
import com.example.WebBookTour.service.ThietketourService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("api/admin/toudulich")
public class TourDuLichRestcontroller {
    @Autowired
    ThietketourService thietketourService;
    @Autowired
    private ChitietlichtrinhService chitietlichtrinhService;

    @GetMapping("/getall")
    public List<Tourdulich> getAllDiaDiem() {
        return thietketourService.getAllTourDuLich();

    }

    @GetMapping("/getpage")
    public Page<TourdulichDto> getTourDuLich() {
        return thietketourService.getTourDuLich(0, 10);
    }

    @PostMapping("/add")
    public String addTourDuLich(@RequestParam("tourDuLichDTO") String tourDuLichDTO, @RequestParam("files") List<MultipartFile> files) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        TourdulichDto tourdulichDto = objectMapper.readValue(tourDuLichDTO, TourdulichDto.class);
        Iterator<ChitietlichtrinhDto> iterator = tourdulichDto.getChitietlichtrinhs().iterator();
        int index = 0;
        while (iterator.hasNext()) {
            ChitietlichtrinhDto cDto = iterator.next();
            cDto.setHinhAnh(chitietlichtrinhService.uploadFile(files.get(index)));
            index++;
        }
        return thietketourService.addTourDulich(tourdulichDto);

    }
}
