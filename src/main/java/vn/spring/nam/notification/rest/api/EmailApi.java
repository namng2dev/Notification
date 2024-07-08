package vn.spring.nam.notification.rest.api;

import jakarta.mail.MessagingException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import vn.spring.nam.notification.api.request.OTPRequest;

@RestController
@RequestMapping("/api")
public interface EmailApi {

    @PostMapping("/send/email/verify/otp")
    @ResponseStatus(HttpStatus.OK)
    void sendMail(@RequestBody OTPRequest request) throws MessagingException;
}
