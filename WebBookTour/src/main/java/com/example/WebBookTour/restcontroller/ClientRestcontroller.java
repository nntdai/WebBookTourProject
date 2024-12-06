package com.example.WebBookTour.restcontroller;

import com.example.WebBookTour.dto.DatchotourDto;
import com.example.WebBookTour.service.datchotour_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user/datchotour")
public class ClientRestcontroller {
    @Autowired
    private datchotour_Service datchotour_service;
    @PostMapping("/add")
    public Integer addDatchotour(@RequestBody DatchotourDto datchotourDto) {
        return datchotour_service.addDatChoTour(datchotourDto).getId();
    }
}
