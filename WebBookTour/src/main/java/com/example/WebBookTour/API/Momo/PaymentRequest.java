package com.example.WebBookTour.API.Momo;

public class PaymentRequest {
    private String orderId; // Mã đơn hàng
    private String amount; // Số tiền thanh toán
    private String orderInfo; // Thông tin đơn hàng (tùy chọn)
    private String returnUrl; // URL quay lại sau khi thanh toán (nếu cần)
    private String notifyUrl; // URL nhận thông báo kết quả thanh toán (nếu cần)

    // Getters và Setters
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(String orderInfo) {
        this.orderInfo = orderInfo;
    }

    public String getReturnUrl() {
        return returnUrl;
    }

    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }
}
