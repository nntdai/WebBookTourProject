package com.example.WebBookTour.restcontroller;

import com.example.WebBookTour.dto.DiadiemDto;
import com.example.WebBookTour.dto.VungmienDto;
import com.example.WebBookTour.entity.Diadiem;
import com.example.WebBookTour.service.DiadiemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin/api/diadiem")
public class DiadiemRestcontroller {
    @Autowired
    DiadiemService diaDiemService;

    @GetMapping
    public Page<DiadiemDto> listDiaDiem(@RequestParam(name = "page", defaultValue = "0") int page,
                                        @RequestParam(name = "size", defaultValue = "10") int size, Model model)
    {
        return diaDiemService.getDiaDiems(page,size);


    }
}
