package com.example.WebBookTour.controller;

import com.example.WebBookTour.model.Taikhoanadmin;
import com.example.WebBookTour.service.TaiKhoanAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class AdminController {
    private TaiKhoanAdminService service;
    @Autowired
    public AdminController(TaiKhoanAdminService service) {
        this.service = service;
    }
    @GetMapping("/")
    public String adminPage(Model model)
    {
        return "adminpage";
    }

//    @GetMapping("/taikhoan/{username}")
//    public Optional<Taikhoanadmin> getTaikhoan(@PathVariable String username) {
//        return service.getTaikhoanByUsername(username);
//    }
}
