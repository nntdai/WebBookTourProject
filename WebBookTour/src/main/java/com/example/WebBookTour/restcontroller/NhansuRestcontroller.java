package com.example.WebBookTour.restcontroller;

import com.example.WebBookTour.dto.NhansuDto;
import com.example.WebBookTour.entity.Nhansu;
import com.example.WebBookTour.repository.NhansuRepository;
import com.example.WebBookTour.service.NhansuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/admin/nhansu")
public class NhansuRestcontroller {

    @Autowired
    private NhansuService nhansuService;

    @GetMapping("/getall")
    public List<NhansuDto> getAll()
        {
            return nhansuService.getAllHDV();
        }

}
