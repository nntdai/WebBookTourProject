package com.example.WebBookTour.controller;

import com.example.WebBookTour.dto.ChitietlichtrinhDto;
import com.example.WebBookTour.dto.TochuctourDto;
import com.example.WebBookTour.dto.TourdulichDto;
import com.example.WebBookTour.dto.VungmienDto;
import com.example.WebBookTour.entity.Tourdulich;
import com.example.WebBookTour.entity.Vungmien;
import com.example.WebBookTour.service.ThietketourService;
import com.example.WebBookTour.service.TochuctourService;
import com.example.WebBookTour.service.VungmienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/")
public class RouteController {
    @Autowired
    private VungmienService vungmienService;

    @Autowired
    private ThietketourService thietketourService;
    @Autowired
    private TochuctourService tochuctourService;

    @GetMapping
    public String getHomePage(Model model)
    {
        LocalDate today = LocalDate.now();
        List<VungmienDto> vungmienDtos = vungmienService.getAllVungMien();
        List<TourdulichDto> dsTourDuLich =  thietketourService.getAllTourDuLich();
        for (TourdulichDto tourdulichDto : dsTourDuLich) {
            Set<ChitietlichtrinhDto> sortedSet = tourdulichDto.getChitietlichtrinhs()
                    .stream()
                    .sorted(Comparator.comparing(ChitietlichtrinhDto::getNgayThu))
                    .collect(Collectors.toCollection(LinkedHashSet::new));
            tourdulichDto.setChitietlichtrinhs(sortedSet); //
        }
        dsTourDuLich.stream()
                .map(tour -> {
                    // Lọc các tổ chức tour có ngày khởi hành >= hôm nay
                    Set<TochuctourDto> filteredTochuctours = tour.getTochuctours().stream()
                            .filter(tochuctour -> {
                                LocalDate ngayKhoiHanh = tochuctour.getNgayKH()
                                        .atZone(ZoneId.systemDefault()) // Chuyển Instant -> ZonedDateTime
                                        .toLocalDate(); // Lấy LocalDate
                                return !ngayKhoiHanh.isBefore(today); // Kiểm tra ngày >= hôm nay
                            })
                            .collect(Collectors.toSet());
                    // Gán danh sách đã lọc lại vào tour
                    tour.setTochuctours(filteredTochuctours);
                    return tour;
                })
                .filter(tour -> !tour.getTochuctours().isEmpty()) // Loại bỏ các tour không có tổ chức nào thỏa mãn
                .collect(Collectors.toList());

        model.addAttribute("dsTourDuLich", dsTourDuLich);
        model.addAttribute("vungmienDtos", vungmienDtos);
        model.addAttribute("var","client/listToChucTour");
        return "client/homepage";
    }

    @GetMapping("/tour/{id}")
    public String xemThongTinTour(Model model, @PathVariable int id)
    {
        LocalDate today = LocalDate.now();
        List<VungmienDto> vungmienDtos = vungmienService.getAllVungMien();
        TourdulichDto tourdulichDto =thietketourService.getTourDulich(id);
        Set<ChitietlichtrinhDto> sortedSet = tourdulichDto.getChitietlichtrinhs()
                .stream()
                .sorted(Comparator.comparing(ChitietlichtrinhDto::getNgayThu))
                .collect(Collectors.toCollection(LinkedHashSet::new));
        tourdulichDto.setChitietlichtrinhs(sortedSet);
        Set<TochuctourDto> tochuctours = tourdulichDto.getTochuctours();
        Map<String, List<Integer>> validDatesWithIds = tochuctours.stream()
                .filter(tochuctour -> {
                    // Chuyển Instant -> LocalDate và kiểm tra ngày >= hôm nay
                    LocalDate ngayKH = tochuctour.getNgayKH()
                            .atZone(ZoneId.systemDefault())
                            .toLocalDate();
                    return !ngayKH.isBefore(today); // Lọc ngày >= hôm nay
                })
                .collect(Collectors.toMap(
                        tochuctour -> tochuctour.getNgayKH()
                                .atZone(ZoneId.systemDefault())
                                .toLocalDate()
                                .toString(), // Khóa là ngày khởi hành dạng String
                        tochuctour -> List.of(tochuctour.getId(), tochuctour.getSoChoCon()) // Giá trị là danh sách [ID, Số chỗ còn]
                ));
        System.out.println(validDatesWithIds);
        model.addAttribute("validDatesWithIds", validDatesWithIds);
        model.addAttribute("tourDulich", tourdulichDto);
        model.addAttribute("vungmienDtos", vungmienDtos);
        model.addAttribute("var","client/thongTinTour");
        return "client/homepage";
    }

    @GetMapping("/tour/book/{id}")
    public String bookTour(Model model, @PathVariable int id) {
        {
            List<VungmienDto> vungmienDtos = vungmienService.getAllVungMien();
            TochuctourDto tochuctourDto = tochuctourService.getToChucTourById(id);
            model.addAttribute("var","client/datTour");
            model.addAttribute("tochuctourDto",tochuctourDto);
            model.addAttribute("vungmienDtos", vungmienDtos);
            return "client/homepage";
        }
    }
}
