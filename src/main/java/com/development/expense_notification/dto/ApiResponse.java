package com.development.expense_notification.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponse {
    private String message;
    private int code;
    private Object data;
}
