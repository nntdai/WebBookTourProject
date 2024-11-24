package com.example.WebBookTour.controller;

import com.example.WebBookTour.dto.DiadiemDto;
import com.example.WebBookTour.dto.TourdulichDto;
import com.example.WebBookTour.service.DiadiemService;
import com.example.WebBookTour.service.ThietketourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        dsDiaDiem = diadiemService.getAllDiaDiems();
//        dsVungMien= vungMienService.getAllVungMien();
        model.addAttribute("var", "thietketour/thietketour");
        model.addAttribute("dsTour", dsTour);
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("page", page);

        return "admin";
    }
    @GetMapping("/{page}")
    public String diaDiemList(Model model,@PathVariable int page)
    {
        Page<TourdulichDto> dsTour = thietketourService.getTourDuLich(page,10);
        int totalPage = dsTour.getTotalPages();
        model.addAttribute("dsTour", dsTour);
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("page", page);
        return "thietketour/thietketour :: tableTourDesign";
    }

//    @GetMapping("/getModalContent")
//    @ResponseBody
//    public String getModalContent(@RequestParam("days") int numDays, Model model) {
//        // Tạo danh sách số ngày từ 1 đến numDays
//        List<Integer> days = IntStream.rangeClosed(1, numDays)
//                .boxed()
//                .collect(Collectors.toList());
//
//        model.addAttribute("days", days);
//
//        // Trả về nội dung fragment cho modal body
//        return ThymeleafUtil.processFragment("modalContent", model);
//    }

    @GetMapping("/add")
    public String showAddTourForm(Model model) {
//        model.addAttribute("dsVungMien", dsVungMien);
        model.addAttribute("dsDiaDiem", dsDiaDiem);
        model.addAttribute("day",1);
        return "thietketour/thietketouradd";
    }

    @GetMapping("/addFormTour/{day}")
    public String addFormTour(Model model,@PathVariable("day") int day)
    {
        model.addAttribute("day",day);
        return "thietketour/thietketouradd :: modalLichTrinh";
    }
}
