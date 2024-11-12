package com.example.WebBookTour.controller;

import com.example.WebBookTour.dto.DiadiemDto;
import com.example.WebBookTour.entity.Diadiem;
import com.example.WebBookTour.service.DiadiemService;
import com.example.WebBookTour.service.VungmienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin/diadiem")
public class DiaDiemController {
    @Autowired
    DiadiemService diaDiemService;
    @Autowired
    VungmienService vungMienService;

    @GetMapping
    public String diadiemPage(Model model) {
        String var = "diadiem";
        List<Diadiem> dsdiadiem = diaDiemService.findAll();

        model.addAttribute("var", var);
        String buttonAddLocation = "diadiemadd";
//        String buttonAddEnable ="add";
//        buttonAddEnable="addUnval";     // Use when no permission
//        model.addAttribute("buttonAdd",buttonAddLocation);
//        model.addAttribute("buttonAddEnable",buttonAddEnable);
        model.addAttribute("dsdiadiem", dsdiadiem);
        return "admin";
    }

    @GetMapping("/add")
    public String showAddLocationForm(Model model) {
//        List<Vungmien> dsVungMien= vungMienService.getAllVungMien();
//        model.addAttribute("dsVungMien", dsVungMien);
//        // Chuẩn bị dữ liệu cần thiết cho form
        model.addAttribute("diadiem", new DiadiemDto());
        return "diadiemadd";
    }
}
