package com.example.WebBookTour.controller;

import com.example.WebBookTour.entity.Taikhoanadmin;
import com.example.WebBookTour.service.TaiKhoanAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private TaiKhoanAdminService service;
    @Autowired
    public AdminController(TaiKhoanAdminService service) {
        this.service = service;
    }

    @GetMapping({"", "/{var}"})
    public String adminPage(Model model,@PathVariable String var)
    {
        model.addAttribute("var", var);
        return "admin";
    }

//    @GetMapping("/tourdulich")
//    public String getTourDuLich(Model model)
//    {
//        return "tourdulich";
//    }

//    @GetMapping("/")
//    public String homePage(Model model)
//    {
//        return "homepage";
//    }
//    @GetMapping("/taikhoan/{username}")
//    public Optional<Taikhoanadmin> getTaikhoan(@PathVariable String username) {
//        return service.getTaikhoanByUsername(username);
//    }
}
