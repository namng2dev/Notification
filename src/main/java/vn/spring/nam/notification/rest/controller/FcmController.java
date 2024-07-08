package vn.spring.nam.notification.rest.controller;

import com.google.firebase.messaging.FirebaseMessagingException;
import org.springframework.web.bind.annotation.RestController;
import vn.spring.nam.notification.api.dto.NotificationDto;
import vn.spring.nam.notification.rest.api.FcmApi;
import vn.spring.nam.notification.service.FcmService;

import java.util.List;

@RestController
public class FcmController implements FcmApi {
    private final FcmService<NotificationDto> fcmService;
    ;

    public FcmController(FcmService<NotificationDto> fcmService) {
        this.fcmService = fcmService;
    }

    @Override
    public void subscribeToTopic(String token, String topic) {
        try {
            fcmService.subscribeToTopic(token, topic);
        } catch (FirebaseMessagingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void multipleSubscribeToTopic(List<String> tokens, String topic) {
        try {
            fcmService.multipleSubscribeToTopic(tokens, topic);
        } catch (FirebaseMessagingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void unsubscribeFromTopic(String token, String topic) {
        try {
            fcmService.unsubscribeFromTopic(token, topic);
        } catch (FirebaseMessagingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void multipleUnsubscribeToTopic(List<String> tokens, String topic) {
        try {
            fcmService.multipleUnsubscribeToTopic(tokens, topic);
        } catch (FirebaseMessagingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void sendToToken(String token, NotificationDto notificationDto) {
        try {
            fcmService.sendNotificationToToken(token, notificationDto);
        } catch (FirebaseMessagingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void sendToTopic(String topic, NotificationDto notificationDto) {
        try {
            fcmService.sendNotificationToTopic(topic, notificationDto);
        } catch (FirebaseMessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
