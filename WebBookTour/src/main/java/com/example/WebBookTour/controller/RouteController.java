package com.example.WebBookTour.controller;

import com.example.WebBookTour.API.Zalopay.ZaloPayService;
import com.example.WebBookTour.dto.*;
import com.example.WebBookTour.entity.Tourdulich;
import com.example.WebBookTour.entity.Vungmien;
import com.example.WebBookTour.service.*;
import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

@Controller
@RequestMapping("/")
public class RouteController {
    @Autowired
    private VungmienService vungmienService;

    @Autowired
    private ThietketourService thietketourService;
    @Autowired
    private TochuctourService tochuctourService;
    @Autowired
    private datchotour_Service datchotour_service;

    @Autowired
    private NhomtuoiService nhomtuoiService;

    @Autowired
    private ZaloPayService zaloPayService;

    @Autowired
    private EmailService emailService;
    @Autowired
    private DiadiemService diadiemService;
    @GetMapping("/listTour")
    public String getListTour(Model model)
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
        List<DiadiemDto> dsDiaDiem = diadiemService.getAllDiaDiems();
        model.addAttribute("dsDiaDiem",dsDiaDiem);
        model.addAttribute("dsTourDuLich", dsTourDuLich);
        model.addAttribute("vungmienDtos", vungmienDtos);
        model.addAttribute("var","client/listToChucTour");
        return "client/homepage";
    }


    @GetMapping
    public String getHomePage(Model model)
    {
        List<VungmienDto> vungmienDtos = vungmienService.getAllVungMien();
        List<DiadiemDto> dsDiaDiem = diadiemService.getAllDiaDiems();
        model.addAttribute("dsDiaDiem",dsDiaDiem);
        model.addAttribute("vungmienDtos", vungmienDtos);
        model.addAttribute("var","client/homePageContent");
        return "client/homepage";
    }
    @GetMapping("/success")
    public String datTourThanhCong(Model model,@RequestParam String apptransid,HttpSession session) throws MessagingException {
        DatchotourDto datTourDto = (DatchotourDto) session.getAttribute("datTourDto");
        System.out.println(datTourDto);

        int status = 0;
        try {
            status = zaloPayService.checkPaymentStatus(apptransid);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        if (status == 1) {
            // Thanh toán thành công
            int id = datchotour_service.addDatChoTour(datTourDto).getId();
            Map<String, Object> templateModel = new HashMap<>();

            templateModel.put("bookingCode", id);

            emailService.sendEmail(datTourDto.getEmail(), "Xác nhận đặt tour", templateModel);
            model.addAttribute("idDatCho", id);
            model.addAttribute("var", "client/thanhCong");
            return "client/homepage"; // Trả về trang thành công
        } else {
            // Thanh toán thất bại
            model.addAttribute("message", "Thanh toán không thành công. Vui lòng thử lại!");
            model.addAttribute("var", "client/error");

        }
        return "client/homepage";
    }
//    @GetMapping("/checkTrangThai")
//    public String datTourThanhCong(@RequestParam String apptransid, Model model) throws Exception {
//        // Gọi API ZaloPay để kiểm tra trạng thái giao dịch
//
//    }
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
            List<NhomtuoiDto> nhomtuoiDtos = nhomtuoiService.getAllNhomTuoi();
            model.addAttribute("var","client/datTour");
            model.addAttribute("tochuctourDto",tochuctourDto);
            model.addAttribute("nhomtuoiDtos",nhomtuoiDtos);
            model.addAttribute("vungmienDtos", vungmienDtos);
            return "client/homepage";
        }
    }
    @GetMapping("/datchoSearch/{value}")
    public String datchoSearch(Model model, @PathVariable String value) {
        DatchotourDto rs=datchotour_service.getDatchotourDto(parseInt(value));
        Instant instantNgayKhoiHanh = rs.getIdToChucTour().getNgayKH();
        if (instantNgayKhoiHanh != null) {
            ZonedDateTime vietnamTimeKH = instantNgayKhoiHanh.atZone(ZoneId.of("Asia/Ho_Chi_Minh"));
            String formattedNgayKhoiHanh = vietnamTimeKH.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
            rs.getIdToChucTour().setFormattedNgayKH(formattedNgayKhoiHanh);  // Lưu ngày khởi hành đã định dạng
        }
        Instant instantNgayKhoiVe = rs.getIdToChucTour().getNgayVe();
        if (instantNgayKhoiVe != null) {
            ZonedDateTime vietnamTimeKH = instantNgayKhoiVe.atZone(ZoneId.of("Asia/Ho_Chi_Minh"));
            String formattedNgayVe = vietnamTimeKH.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
            rs.getIdToChucTour().setFormattedNgayVe(formattedNgayVe);  // Lưu ngày khởi hành đã định dạng
        }
        Instant instantNgayDatCho = rs.getNgayDatCho();
        if (instantNgayDatCho != null) {
            ZonedDateTime vietnamTimeKH = instantNgayDatCho.atZone(ZoneId.of("Asia/Ho_Chi_Minh"));
            String formattedNgayDatCho = vietnamTimeKH.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
            rs.setFormattedNgayDatCho(formattedNgayDatCho);  // Lưu ngày khởi hành đã định dạng
        }
        model.addAttribute("datchotour",rs);
        model.addAttribute("var","client/datchoSearch");
        return "client/homepage";
    }
    @GetMapping("/searchSDT/{sdt}")
    public String searchSDT(Model model, @PathVariable String sdt) {
        // Tìm kiếm danh sách đặt tour theo số điện thoại
        List<DatchotourDto> ds = datchotour_service.traCuuBangSdt(sdt);

        // Lặp qua danh sách DatchotourDto và xử lý ngày khởi hành, ngày về và ngày đặt cho
        for (DatchotourDto datchotourDto : ds) {
            // Xử lý ngày khởi hành
            Instant instantNgayKhoiHanh = datchotourDto.getIdToChucTour().getNgayKH();
            if (instantNgayKhoiHanh != null) {
                ZonedDateTime vietnamTimeKH = instantNgayKhoiHanh.atZone(ZoneId.of("Asia/Ho_Chi_Minh"));
                String formattedNgayKhoiHanh = vietnamTimeKH.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
                datchotourDto.getIdToChucTour().setFormattedNgayKH(formattedNgayKhoiHanh);  // Lưu ngày khởi hành đã định dạng
            }

            // Xử lý ngày về
            Instant instantNgayKhoiVe = datchotourDto.getIdToChucTour().getNgayVe();
            if (instantNgayKhoiVe != null) {
                ZonedDateTime vietnamTimeVe = instantNgayKhoiVe.atZone(ZoneId.of("Asia/Ho_Chi_Minh"));
                String formattedNgayVe = vietnamTimeVe.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
                datchotourDto.getIdToChucTour().setFormattedNgayVe(formattedNgayVe);  // Lưu ngày về đã định dạng
            }

            // Xử lý ngày đặt tour
            Instant instantNgayDatCho = datchotourDto.getNgayDatCho();
            if (instantNgayDatCho != null) {
                ZonedDateTime vietnamTimeDatCho = instantNgayDatCho.atZone(ZoneId.of("Asia/Ho_Chi_Minh"));
                String formattedNgayDatCho = vietnamTimeDatCho.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
                datchotourDto.setFormattedNgayDatCho(formattedNgayDatCho);  // Lưu ngày đặt tour đã định dạng
            }
        }
        Collections.reverse(ds);  // Đảo ngược danh sách
        // Thêm đối tượng model cho giao diện
        model.addAttribute("ds", ds);
        model.addAttribute("var", "client/datChoSearchSdt");
        return "client/homepage";  // Trả về trang homepage
    }

}
