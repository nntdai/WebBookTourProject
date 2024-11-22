package com.example.WebBookTour.restcontroller;

import com.example.WebBookTour.dto.DiadiemDto;

import com.example.WebBookTour.dto.TourdulichDto;
import com.example.WebBookTour.entity.Tourdulich;
import com.example.WebBookTour.service.ThietketourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/admin/toudulich")
public class TourDuLichRestcontroller {
    @Autowired
    ThietketourService thietketourService;

    @GetMapping("/getall")
    public List<Tourdulich> getAllDiaDiem()
    {
        return thietketourService.getAllTourDuLich();

    }
    @GetMapping("/getpage")
    public Page<TourdulichDto> getTourDuLich() {
      return thietketourService.getTourDuLich(0,10);
    }

    @PostMapping("/add")
    public int addTourDuLich(@RequestBody TourdulichDto tourdulichDto) {
        return thietketourService.addTourDulich(tourdulichDto);
    }
}
