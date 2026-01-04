package com.development.expense_notification.dto;

import lombok.Data;

@Data
public class SendOTPRequest {
    private Long chatId;
    private String otp;
}
