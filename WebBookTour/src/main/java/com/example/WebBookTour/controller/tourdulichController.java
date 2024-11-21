package com.example.WebBookTour.controller;

import com.example.WebBookTour.dto.TourdulichDto;
import com.example.WebBookTour.service.DiadiemService;
import com.example.WebBookTour.service.tourdulichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("api/tourdulich")
public class tourdulichController {

    @Autowired
    private tourdulichService tourService;

    @Autowired
    private DiadiemService diaDiemService;

    // Lấy danh sách tất cả các tour
    @GetMapping("/all") //http://localhost:8088/api/tourdulich
    public List<TourdulichDto> getAllTourdulich(){
        return tourService.getAllTours();
    }


    @RequestMapping(value = "/search/tour-list",method = RequestMethod.GET)
    public List<TourdulichDto> tourList(@RequestParam(name="diaDiemThamQuan",required = false) Integer diaDiemThamQuan,
                                        @RequestParam(name="diaDiemKhoiHanh",required = false) Integer diaDiemKhoiHanh,
                                        @RequestParam(name="priceTo",required = false) Integer priceTo,
                                        @RequestParam(name="priceForm",required = false) Integer priceForm){
        List<TourdulichDto> listTourDuLich = tourService.getByFind(diaDiemThamQuan,diaDiemKhoiHanh,priceTo,priceForm);
        return listTourDuLich;
    }

}
