package com.example.WebBookTour.controller;

import com.example.WebBookTour.dto.VungmienDto;
import com.example.WebBookTour.entity.Vungmien;
import com.example.WebBookTour.service.VungmienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class RouteController {
    @Autowired
    private VungmienService vungmienService;


    @GetMapping
    public String getHomePage(Model model)
    {
        List<VungmienDto> vungmienDtos = vungmienService.getAllVungMien();
        model.addAttribute("vungmienDtos", vungmienDtos);
        return "client/homepage";
    }

}
