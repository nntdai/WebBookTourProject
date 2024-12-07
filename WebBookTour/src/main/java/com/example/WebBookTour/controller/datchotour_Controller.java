package com.example.WebBookTour.controller;

import com.example.WebBookTour.dto.*;
import com.example.WebBookTour.model.tourdulichDTO;
import com.example.WebBookTour.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
    tourdulichService tourdulichService;
    @Autowired
    ThongtinhanhkhachService thongtinhanhkhachService;
    @Autowired
    Khachhang_Service khachhang_service;
    private List<TochuctourDto> dsTochuctour;
    private List<KhachhangDto> dsKhachhang;
    private List<KhuyenmaiDto> dsKhuyenmai;
    private List<TourdulichDto> dsTourdulich;
    private List<ThongtinhanhkhachDto> dsThongtinhanhkhach;
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
    @GetMapping("/searchall")
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
    @GetMapping("/search")
    public String getinfo (Model model) {
        dsTochuctour=tochuctour_service.getAllTochuctour();
        dsKhachhang=khachhang_service.getAllKhachhang();
        dsKhuyenmai=khuyenmai_service.getAllKhuyenmai();
        dsTourdulich=tourdulichService.getAllTourdulich();
        if(dsTochuctour == null){
            System.out.println("dsTochuctour is null");
        }
        System.out.println("dsTochuctour not null");
        System.out.println(dsTochuctour.get(0).getIdTourDuLich().getTen());
        model.addAttribute("dsTochuctour", dsTochuctour);
        model.addAttribute("dsTourdulich", dsTourdulich);
        model.addAttribute("dsKhachhang",dsKhachhang);
        model.addAttribute("dsKhuyenmai",dsKhuyenmai);
        return "datchotour/Searchdatchotour";
    }
    @GetMapping("/filter")
    public String Getfilter (
            @RequestParam String matour,
            @RequestParam String tourdl,
            @RequestParam String sdt,
            Model model){
        if(tourdl.equals("0")){
            tourdl="";
        }
        if(sdt.equals("0")){
            sdt="";
        }
        Page<DatchotourDto> rs=datchotour_service.getFilterDatchotour(0, 10, matour, tourdl, sdt);
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
}
