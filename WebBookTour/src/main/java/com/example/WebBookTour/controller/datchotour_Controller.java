package com.example.WebBookTour.controller;

import com.example.WebBookTour.dto.DatchotourDto;
import com.example.WebBookTour.dto.KhachhangDto;
import com.example.WebBookTour.dto.KhuyenmaiDto;
import com.example.WebBookTour.dto.TochuctourDto;
import com.example.WebBookTour.service.Khachhang_Service;
import com.example.WebBookTour.service.Khuyenmai_Service;
import com.example.WebBookTour.service.Tochuctour_Service;
import com.example.WebBookTour.service.datchotour_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/admin/datchotour")
public class datchotour_Controller {
    @Autowired
    datchotour_Service datchotour_service;
    @Autowired
    Tochuctour_Service tochuctour_service;
    @Autowired
    Khuyenmai_Service khuyenmai_service;
    @Autowired
    Khachhang_Service khachhang_service;
    private List<TochuctourDto> dsTochuctour;
    private List<KhachhangDto> dsKhachhang;
    private List<KhuyenmaiDto> dsKhuyenmai;
    @GetMapping
    public String datchotourPage(Model model) {
        Page<DatchotourDto> dsDatchotour = datchotour_service.getDatchotour(0, 10);
        int page = dsDatchotour.getPageable().getPageNumber();
        int totalPage = dsDatchotour.getTotalPages();
        dsTochuctour=tochuctour_service.getAllTochuctour();
        dsKhachhang=khachhang_service.getAllKhachhang();
        dsKhuyenmai=khuyenmai_service.getAllKhuyenmai();
        model.addAttribute("var", "datchotour/datchotour");
        model.addAttribute("dsDatchotour", dsDatchotour);
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("page", page);
        return "admin";
    }
    @GetMapping("/{page}")
    public String datchotourList(Model model, @PathVariable int page) {
        Page<DatchotourDto> dsDatchotour=datchotour_service.getDatchotour(page, 10);
        int totalPage=dsDatchotour.getTotalPages();
        model.addAttribute("dsDatchotour", dsDatchotour);
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("page", page);
        return "datchotour/datchotour :: tableDatchotour";
    }
    @GetMapping("/view/{id}")
    public String ViewDatchotour(@PathVariable int id, Model model) {
        DatchotourDto rs=datchotour_service.getDatchotourDto(id);
        if (rs == null) {
            throw new RuntimeException("Không tìm thấy dữ liệu với ID: " + id);
        }
        System.out.println("Đã tìm thấy đối tượng: " + rs);
        model.addAttribute("datchotour",rs);
        return "datchotour/viewDatchotour";
    }
    @GetMapping("/search")
    public String searchDatchotour(
            @RequestParam String keyword, Model model){
        Page<DatchotourDto> rs=datchotour_service.getSearchDatchotour(0, 10, keyword);
        if (rs == null) {
            throw new RuntimeException("Không tìm thấy dữ liệu với ID: ");
        }
        int page = rs.getPageable().getPageNumber();
        int totalPage = rs.getTotalPages();
        System.out.println("Đã tìm thấy đối tượng: " + rs);
        model.addAttribute("dsDatchotour", rs);
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("page", page);
        return "datchotour/datchotour :: tableDatchotour";
    }
//    public String showtourdulich(Model model) {
//        dsTochuctour=tochuctour_service.getAllTochuctour();
//    }
}
