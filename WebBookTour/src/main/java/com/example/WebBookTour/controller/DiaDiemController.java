package com.example.WebBookTour.controller;

import com.example.WebBookTour.dto.DiadiemDto;
import com.example.WebBookTour.entity.Diadiem;
import com.example.WebBookTour.entity.Vungmien;
import com.example.WebBookTour.service.DiadiemService;
import com.example.WebBookTour.service.VungmienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/diadiem")
public class DiaDiemController {
    @Autowired
    DiadiemService diaDiemService;
    @Autowired
    VungmienService vungMienService;

    private List<Vungmien> dsVungMien;
    @GetMapping
    public String diadiemPage(Model model) {
        Page<DiadiemDto> dsDiaDiem = diaDiemService.getDiaDiems(2,10);
        dsVungMien= vungMienService.getAllVungMien();
        model.addAttribute("var", "diadiem");
        model.addAttribute("dsDiaDiem", dsDiaDiem);
        return "admin";
    }

    @GetMapping("/add")
    public String showAddLocationForm(Model model) {
        model.addAttribute("dsVungMien", dsVungMien);
        return "diadiemadd";
    }

//    @PostMapping("/add")
//    public String addDiadiem(@ModelAttribute("diadiemDto") DiadiemDto diadiemDto,Model model) {
//        // Lưu địa điểm mới thông qua DiadiemService
//        Diadiem diadiemE = new Diadiem();
//        Vungmien vungMienE = new Vungmien();
//        vungMienE.setId(diadiemDto.getIdVungMien().getId());
//        vungMienE.setTen(diadiemDto.getIdVungMien().getTen());
//        diadiemE.setTen(diadiemDto.getTen());
//        diadiemE.setIdVungMien(vungMienE);
//        try {
//            diaDiemService.saveDiaDiem(diadiemE);  // Gọi service lưu địa điểm
//
//        } catch (Exception e) {
//            model.addAttribute("message", "Có lỗi xảy ra khi thêm địa điểm.");
//            model.addAttribute("alertClass", "alert-danger"); // Class Bootstrap cho thông báo lỗi
//        }
//        return "redirect:/admin/diadiem"; // Chuyển hướng về trang danh sách địa điểm sau khi thêm thành công
//    }
}
