package vn.spring.nam.notification.api.request;

import lombok.Getter;
import lombok.ToString;

@Getter
public class OTPRequest {
    private String email;
    private String otp;
    private String fullName;
}
