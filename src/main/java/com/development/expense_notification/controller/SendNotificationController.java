package com.development.expense_notification.controller;

import com.development.expense_notification.dto.SendNotificationRequest;
import com.development.expense_notification.service.SendNotificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/notification")
public class SendNotificationController {

    private final SendNotificationService sendNotificationService;

    public SendNotificationController(SendNotificationService sendNotificationService) {
        this.sendNotificationService = sendNotificationService;
    }

    @PostMapping
    public ResponseEntity<Object> sendNotification(@RequestBody SendNotificationRequest request) {
        var response = sendNotificationService.sendNotification(request);
        return ResponseEntity.ok(response);
    }
}