package com.example.WebBookTour.restcontroller;

import com.example.WebBookTour.dto.VungmienDto;
import com.example.WebBookTour.entity.Vungmien;
import com.example.WebBookTour.service.VungmienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/admin/vungmien")
public class VungmienRestcontroller {

    @Autowired
    private VungmienService vungmienService;

    @GetMapping
    public List<VungmienDto> getAllVungmien() {
        return vungmienService.getAllVungMien();
    }

   

}
