package com.example.WebBookTour.restcontroller;

import com.example.WebBookTour.dto.DatchotourDto;
import com.example.WebBookTour.service.datchotour_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin/datchotour")
public class datchotour_Restcontroller {
    @Autowired
    datchotour_Service datchotour_service;
    @GetMapping
    public Page<DatchotourDto> listDatchotour(@RequestParam(name = "page", defaultValue = "0") int page,
                                              @RequestParam(name = "size", defaultValue = "10") int size, Model model) {
        return datchotour_service.getDatchotour(page, size);
    }
    public DatchotourDto getDatchotourDto(DatchotourDto dto) {
        return datchotour_service.getDatchotourDto(dto.getId());
    }

}
