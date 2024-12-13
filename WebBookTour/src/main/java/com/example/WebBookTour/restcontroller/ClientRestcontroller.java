package com.example.WebBookTour.restcontroller;

import com.example.WebBookTour.dto.DatchotourDto;
import com.example.WebBookTour.service.datchotour_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.lang.Integer.parseInt;

@RestController
@RequestMapping("/api/user/datchotour")
public class ClientRestcontroller {
    @Autowired
    private datchotour_Service datchotour_service;
    @PostMapping("/add")
    public DatchotourDto addDatchotour(@RequestBody DatchotourDto datchotourDto) {
        return datchotour_service.addDatChoTour(datchotourDto);
    }
    @GetMapping("/datchoSearch/{value}")
    public Boolean datchoSearch(@PathVariable String value) {
        DatchotourDto rs=datchotour_service.getDatchotourDto(parseInt(value));
        return rs != null;
    }

    @GetMapping("/searchSDT/{sdt}")
    public List<DatchotourDto> findBySoDt(@PathVariable String sdt) {

        return datchotour_service.traCuuBangSdt(sdt);
    }
}
