package com.development.expense_notification.template;

import com.development.expense_notification.dto.SendOTPRequest;

public class VerificationTemplate {

    public StringBuilder sendOTP(SendOTPRequest request) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\uD83D\uDD10 <b>Identity Check Required</b>");
        stringBuilder.append("\n\n");
        stringBuilder.append("ពាក្យសម្ងាត់ប្រើតែមួយដងរបស់អ្នក (OTP) គឺ៖");
        stringBuilder.append("\n\n");
        stringBuilder.append("\uD83D\uDD11 ").append("<code>").append(request.getOtp()).append("</code>");
        stringBuilder.append("\n\n");
        stringBuilder.append("⌛\uFE0F ផុតកំណត់ក្នុងរយះពេល៖ 120 វិនាទី");
        stringBuilder.append("\n");
        stringBuilder.append("\uD83D\uDEE1 គន្លឹះសុវត្ថិភាព៖ កុំផ្តល់ OTP របស់អ្នកទៅនរណាម្នាក់");
        stringBuilder.append("\n\n");
        stringBuilder.append("Let’s keep your account safe \uD83D\uDC99");
        return stringBuilder;
    }
}
