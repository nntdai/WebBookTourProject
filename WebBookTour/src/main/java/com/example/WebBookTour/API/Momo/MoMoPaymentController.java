package com.example.WebBookTour.API.Momo;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/payment")
public class MoMoPaymentController {
    private static final String MOMO_ENDPOINT = "https://test-payment.momo.vn/v2/gateway/api/create";
    private static final String PARTNER_CODE = "MOMOIOLD20190129";
    private static final String ACCESS_KEY = "SvDmj2cOTYZmQQ3H";
    private static final String SECRET_KEY = "YOUR_SECRET_KEY";

    @PostMapping("/create")
    public ResponseEntity<?> createPayment(@RequestBody PaymentRequest request) {
        try {
            // Tạo payload gửi tới MoMo
            String requestId = UUID.randomUUID().toString();
            Map<String, String> payload = new HashMap<>();
            payload.put("partnerCode", PARTNER_CODE);
            payload.put("accessKey", ACCESS_KEY);
            payload.put("requestId", requestId);
            payload.put("orderId", request.getOrderId());
            payload.put("amount", request.getAmount());
            payload.put("orderInfo", "Thanh toán test MoMo");
            payload.put("returnUrl", "http://localhost:8080/payment/return");
            payload.put("notifyUrl", "http://localhost:8080/payment/notify");
            payload.put("requestType", "captureWallet");

            // Tính signature
            String rawData = "accessKey=" + ACCESS_KEY +
                    "&amount=" + request.getAmount() +
                    "&orderId=" + request.getOrderId() +
                    "&orderInfo=Thanh toán test MoMo" +
                    "&partnerCode=" + PARTNER_CODE +
                    "&requestId=" + requestId +
                    "&returnUrl=http://localhost:8080/payment/return" +
                    "&notifyUrl=http://localhost:8080/payment/notify" +
                    "&requestType=captureWallet";
            String signature = hmacSHA256(rawData, SECRET_KEY);
            payload.put("signature", signature);

            // Gửi request
            RestTemplate restTemplate = new RestTemplate();
            HttpEntity<Map<String, String>> entity = new HttpEntity<>(payload);
            ResponseEntity<String> response = restTemplate.postForEntity(MOMO_ENDPOINT, entity, String.class);

            return ResponseEntity.ok(response.getBody());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
        }
    }

    private String hmacSHA256(String data, String secret) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(secret.getBytes(), "HmacSHA256");
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(secretKeySpec);
        byte[] hash = mac.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(hash);
    }
}
