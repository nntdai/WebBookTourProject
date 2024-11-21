package com.example.WebBookTour.controller;

import com.example.WebBookTour.dto.TourdulichDto;
import com.example.WebBookTour.exceptions.DataNotFoundException;
import com.example.WebBookTour.service.tourdulichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/tourdulich")
public class tourdulichController {

    @Autowired
    private tourdulichService tourService;

    // Lấy danh sách tất cả các tour
    @GetMapping("/all") //http://localhost:8088/api/tourdulich
    public List<TourdulichDto> getAllTourdulich(){
        return tourService.getAllTours();
    }

    @RequestMapping(value = "/tour-list",method = RequestMethod.GET)
    public ModelAttribute tourList(){

        return null;
    }

}
