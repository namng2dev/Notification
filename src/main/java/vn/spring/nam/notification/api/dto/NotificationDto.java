package vn.spring.nam.notification.api.dto;

import lombok.Getter;

import java.util.Map;

@Getter
public class NotificationDto {
//    private String token;
    private String title;

    private String bodyMessage;

    private Map<String, String> data;
}
