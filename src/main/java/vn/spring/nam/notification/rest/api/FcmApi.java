package vn.spring.nam.notification.rest.api;

import org.springframework.web.bind.annotation.*;
import vn.spring.nam.notification.api.dto.NotificationDto;

import java.util.List;

@RestController
@RequestMapping("/api/notification/fcm")
public interface FcmApi {
    @PostMapping("/subscribe")
    void subscribeToTopic(@RequestParam String token, @RequestParam String topic);

    @PostMapping("/multiple/subscribe")
    void multipleSubscribeToTopic(@RequestBody List<String> tokens, @RequestParam String topic);

    @PostMapping("/unsubscribe")
    void unsubscribeFromTopic(@RequestParam String token, @RequestParam String topic);

    @PostMapping("/multiple/unsubscribe")
    void multipleUnsubscribeToTopic(@RequestBody List<String> tokens, @RequestParam String topic);

    @PostMapping("/send/token")
    void sendToToken(@RequestParam String token, @RequestBody NotificationDto notificationDto);

    @PostMapping("/send/topic")
    void sendToTopic(@RequestParam String topic, @RequestBody NotificationDto notificationDto);
}
