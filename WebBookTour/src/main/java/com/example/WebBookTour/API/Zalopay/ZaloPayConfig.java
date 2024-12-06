package com.example.WebBookTour.API.Zalopay;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ZaloPayConfig {

    @Bean
    public ZaloPayService zaloPayService() {
        return new ZaloPayService();
    }
}
