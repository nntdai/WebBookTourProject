package com.example.WebBookTour.controller;

import com.example.WebBookTour.dto.DatchotourDto;
import com.example.WebBookTour.dto.DiadiemDto;
import com.example.WebBookTour.dto.NhansuDto;
import com.example.WebBookTour.service.NhansuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/admin/nhansu")
public class NhanSuController {
    @Autowired
    NhansuService nhansuService;
    @GetMapping
    public String NhansuPage(Model model) {
        Page<NhansuDto> dsNhansuAll = nhansuService.getNhanSu(0, 10);
        List<NhansuDto> dsNhansulist = dsNhansuAll.getContent();

// Lọc danh sách
        List<NhansuDto> filteredList = dsNhansulist.stream()
                .filter(NhansuDto::getStatus) // Chỉ giữ các phần tử có status = true
                .collect(Collectors.toList());
        Page<NhansuDto> filteredPage = new PageImpl<>(
                filteredList, // Danh sách đã lọc
                dsNhansuAll.getPageable(), // Thông tin phân trang gốc
                filteredList.size() // Tổng số phần tử mới
        );
        int page = filteredPage.getPageable().getPageNumber();
        int totalPage = filteredPage.getTotalPages();
        model.addAttribute("var", "Nhansu/Nhansu");
        model.addAttribute("dsNhansu", filteredPage);
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("page", page);
        return "admin";
    }
    @GetMapping("/{page}")
    public String NhansuList(Model model, @PathVariable int page) {
        Page<NhansuDto> dsNhansu=nhansuService.getNhanSu(page, 10);
        int totalPage=dsNhansu.getTotalPages();
        model.addAttribute("dsNhansu", dsNhansu);
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("page", page);
        return "Nhansu/Nhansu :: tableNhanSu";
    }
    @GetMapping("/edit/{id}")
    public String showEditLocationForm(Model model,@PathVariable int id) {
        NhansuDto nhansuDto = nhansuService.getNhansuById(id);
        model.addAttribute("nhansu", nhansuDto);
        return "Nhansu/Nhansuedit";
    }
}
