package com.example.WebBookTour.restcontroller;

import com.example.WebBookTour.dto.DatchotourDto;
import com.example.WebBookTour.service.datchotour_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/datchotour")
public class datchotour_Restcontroller {
    @Autowired
    datchotour_Service datchotour_service;
    @GetMapping
    public Page<DatchotourDto> listDatchotour(@RequestParam(name = "page", defaultValue = "0") int page,
                                              @RequestParam(name = "size", defaultValue = "10") int size, Model model) {
        return datchotour_service.getDatchotour(page, size);
    }
    public DatchotourDto getDatchotourDto(DatchotourDto dto) {
        return datchotour_service.getDatchotourDto(dto.getId());
    }

//    @GetMapping("/search")
//    public ResponseEntity<Page<DatchotourDto>> searchDatchotour(
//            @RequestParam String keyword,
//            @RequestParam int page,
//            @RequestParam int size){
//        System.out.println(page + " " +size+" "+keyword);
//        Page<DatchotourDto> rs=datchotour_service.getSearchDatchotour(page, size, keyword);
//        if (rs == null) {
//            throw new RuntimeException("Không tìm thấy dữ liệu với ID: ");
//        }
//        System.out.println("Đã tìm thấy đối tượng: " + rs);
//        return ResponseEntity.ok(rs);
//    }
}
