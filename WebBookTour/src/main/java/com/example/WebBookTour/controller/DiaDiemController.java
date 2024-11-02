package com.example.WebBookTour.controller;

import com.example.WebBookTour.entity.Diadiem;
import com.example.WebBookTour.service.DiaDiemService;
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
    DiaDiemService diaDiemService;

    @GetMapping
    public String diadiemPage(Model model) {
        String var = "diadiem";
        List<Diadiem> dsdiadiem = diaDiemService.findAll();
        model.addAttribute("var", var);
        model.addAttribute("dsdiadiem", dsdiadiem);
        return "admin";
    }
}
