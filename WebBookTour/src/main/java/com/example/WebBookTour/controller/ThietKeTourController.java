package com.example.WebBookTour.controller;

import com.example.WebBookTour.dto.DiadiemDto;
import com.example.WebBookTour.dto.TourdulichDto;
import com.example.WebBookTour.service.DiadiemService;
import com.example.WebBookTour.service.ThietketourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin/tourdesign")
public class ThietKeTourController {
    @Autowired
    ThietketourService thietketourService;

    @Autowired
    DiadiemService diadiemService;


    List<DiadiemDto> dsDiaDiem;
    @GetMapping
    public String tourDesignPage(Model model) {
        Page<TourdulichDto> dsTour = thietketourService.getTourDuLich(0,10);
        int page = dsTour.getPageable().getPageNumber();
        int totalPage = dsTour.getTotalPages();
        dsDiaDiem = diadiemService.getDiaDiems(0,10).getContent();
//        dsVungMien= vungMienService.getAllVungMien();
        model.addAttribute("var", "thietketour/thietketour");
        model.addAttribute("dsTour", dsTour);
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("page", page);
        return "admin";
    }

    @GetMapping("/add")
    public String showAddTourForm(Model model) {
//        model.addAttribute("dsVungMien", dsVungMien);
        model.addAttribute("dsDiaDiem", dsDiaDiem);
        return "thietketour/thietketouradd";
    }
}
