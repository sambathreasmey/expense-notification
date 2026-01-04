package com.development.expense_notification.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SendNotificationRequest {
    private Long chatId;
    private String title;
    private String fullName;
    private String categoryName;
    private String amount;
    private String bookingDate;
}
