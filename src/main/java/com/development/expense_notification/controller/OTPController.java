package com.development.expense_notification.controller;

import com.development.expense_notification.dto.SendOTPRequest;
import com.development.expense_notification.service.VerificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/verification")
public class OTPController {
    private final VerificationService verificationService;

    public OTPController(VerificationService verificationService) {
        this.verificationService = verificationService;
    }

    @PostMapping("/send-otp")
    public ResponseEntity<Object> sendOTP(@RequestBody SendOTPRequest request) {
        var response = verificationService.sendOTP(request);
        return ResponseEntity.ok(response);
    }
}
