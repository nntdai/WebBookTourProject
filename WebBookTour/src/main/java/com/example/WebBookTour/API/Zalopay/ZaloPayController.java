package com.example.WebBookTour.API.Zalopay;

import com.example.WebBookTour.dto.DatchotourDto;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/zalopay/")
public class ZaloPayController {

    @Autowired
    private ZaloPayService zaloPayService;

    @PostMapping("/create-order")
    public ResponseEntity<?> createOrder(@RequestBody DatchotourDto datchotourDto, HttpSession session) {
        try {
            // Kiểm tra xem datTourDto có được truyền lên đúng hay không
            if (datchotourDto == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("DatTourDto không hợp lệ");
            }

            // Lưu datTourDto vào session
            session.setAttribute("datTourDto", datchotourDto);

            // Gọi ZaloPay API để tạo đơn hàng
            JSONObject orderResponse = zaloPayService.createOrder(datchotourDto);
            String orderUrl = orderResponse.getString("orderurl");
            String appTransId = orderResponse.getString("apptransid");

            // Trả về orderUrl và appTransId
            Map<String, String> response = new HashMap<>();
            response.put("orderurl", orderUrl);
            response.put("apptransid", appTransId);

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            // Log lỗi chi tiết
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Có lỗi xảy ra: " + e.getMessage());
        }
    }

//    @GetMapping("/check-status")
//    public ResponseEntity<?> checkStatus(@RequestParam String apptransid) {
//        try {
//            JSONObject statusResponse = zaloPayService.checkPaymentStatus(apptransid);
//            return ResponseEntity.ok(statusResponse.toString());
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body("Không thể kiểm tra trạng thái đơn hàng: " + e.getMessage());
//        }
//    }
}
