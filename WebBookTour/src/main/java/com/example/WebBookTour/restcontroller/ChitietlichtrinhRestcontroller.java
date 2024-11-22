package com.example.WebBookTour.restcontroller;

import com.example.WebBookTour.dto.ChitietlichtrinhDto;

import com.example.WebBookTour.entity.Chitietlichtrinh;
import com.example.WebBookTour.service.ChitietlichtrinhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/admin/lichtrinh")
public class ChitietlichtrinhRestcontroller {
    @Autowired
    private ChitietlichtrinhService chitietlichtrinhService;
    @PostMapping("/add")
    public List<Chitietlichtrinh> addChiTietLichTrinh(@RequestBody List<ChitietlichtrinhDto> chitietlichtrinhDtoList)
    {
        return chitietlichtrinhService.saveListLichTrinh(chitietlichtrinhDtoList);

    }
}
