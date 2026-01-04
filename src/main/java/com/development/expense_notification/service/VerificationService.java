package com.development.expense_notification.service;

import com.development.expense_notification.constant.CodeConstant;
import com.development.expense_notification.constant.MessageConstant;
import com.development.expense_notification.dto.ApiResponse;
import com.development.expense_notification.dto.SendOTPRequest;
import com.development.expense_notification.rest.SendMessageBotResponse;
import com.development.expense_notification.template.VerificationTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class VerificationService {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${telegram-bot-token}")
    private String botToken;

    public ApiResponse sendOTP(SendOTPRequest request) {
        VerificationTemplate template = new VerificationTemplate();
        StringBuilder textMessage = template.sendOTP(request);
        return sendOTP(request.getChatId(), textMessage);
    }

    private ApiResponse sendOTP(Long chatId, StringBuilder message) {
        ApiResponse response = new ApiResponse();
        try {
            StringBuilder url = new StringBuilder().append("https://api.telegram.org/bot")
                    .append(botToken)
                    .append("/sendMessage?chat_id=")
                    .append(chatId)
                    .append("&text=")
                    .append(message.toString())
                    .append("&parse_mode=")
                    .append("HTML");
            System.out.println("url = " + url);
            var data = restTemplate.getForObject(url.toString(), SendMessageBotResponse.class);
            if (data == null) {
                response.setCode(CodeConstant.FAILED);
                response.setMessage(MessageConstant.FAILED);
                return response;
            }
            if (!data.getOk()) {
                response.setCode(CodeConstant.FAILED);
                response.setMessage(MessageConstant.FAILED);
                return response;
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            response.setCode(CodeConstant.INTERNAL_SERVER_ERROR);
            response.setMessage(MessageConstant.INTERNAL_SERVER_ERROR);
            return response;
        }
        response.setCode(CodeConstant.SUCCESS);
        response.setMessage(MessageConstant.SUCCESS);
        return response;
    }
}
