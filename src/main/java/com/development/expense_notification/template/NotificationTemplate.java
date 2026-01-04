package com.development.expense_notification.template;

import com.development.expense_notification.dto.SendNotificationRequest;

public class NotificationTemplate {

    public StringBuilder generateNotification(SendNotificationRequest notification) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<b>");
        stringBuilder.append("ព័ត៌មានប្រតិបតិ្តការចំណាយលំអិត");
        stringBuilder.append("</b>");
        stringBuilder.append("\n\n");
        stringBuilder.append("\uD83D\uDECD ចំណាយលើ ៖ ").append(notification.getTitle());
        stringBuilder.append("\n\n");
        stringBuilder.append("\uD83E\uDDD1\u200D\uD83C\uDF3E ឈ្នោះអ្នកប្រើប្រាស់ ៖ ").append(notification.getFullName());
        stringBuilder.append("\n\n");
        stringBuilder.append("\uD83C\uDFAF ប្រភេទ ៖ ").append(notification.getCategoryName());
        stringBuilder.append("\n\n");
        stringBuilder.append("\uD83D\uDC8E ចំនួន ៖ ").append(notification.getAmount());
        stringBuilder.append("\n\n");
        stringBuilder.append("⏰ ប្រតិបត្តិការ ៖ ").append(notification.getBookingDate());
        return stringBuilder;
    }
}
