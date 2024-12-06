package com.example.WebBookTour.restcontroller;
import com.example.WebBookTour.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.mail.MessagingException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/email")
public class EmailRescontroller {
    @Autowired
    private EmailService emailService;

    @PostMapping("/send")
    public String sendEmail(@RequestParam String email,@RequestParam String bookingCode) {
        try {
            // Dữ liệu truyền vào template
            Map<String, Object> templateModel = new HashMap<>();

            templateModel.put("bookingCode", bookingCode);

            emailService.sendEmail(email, "Xác nhận đặt tour", templateModel);
            return "Email đã được gửi thành công!";
        } catch (MessagingException e) {
            e.printStackTrace();
            return "Gửi email thất bại: " + e.getMessage();
        }
    }
}
