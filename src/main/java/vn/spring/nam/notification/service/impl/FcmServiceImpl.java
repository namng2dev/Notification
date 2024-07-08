package vn.spring.nam.notification.service.impl;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import vn.spring.nam.notification.api.dto.NotificationDto;
import vn.spring.nam.notification.service.FcmService;

import java.util.Arrays;
import java.util.List;

@Service
public class FcmServiceImpl implements FcmService<NotificationDto> {

    private static final Logger log = LoggerFactory.getLogger(FcmServiceImpl.class);
    private final FirebaseMessaging firebaseMessaging;

    public FcmServiceImpl(FirebaseMessaging firebaseMessaging) {
        this.firebaseMessaging = firebaseMessaging;
    }

    @Override
    public void subscribeToTopic(String token, String topic) throws FirebaseMessagingException {
        List<String> tokens = Arrays.asList(token);
        firebaseMessaging.subscribeToTopic(tokens, topic);
    }

    @Override
    public void multipleSubscribeToTopic(List<String> tokens, String topic) throws FirebaseMessagingException {
        firebaseMessaging.subscribeToTopic(tokens, topic);
    }

    @Override
    public void unsubscribeFromTopic(String token, String topic) throws FirebaseMessagingException {
        firebaseMessaging.unsubscribeFromTopic(Arrays.asList(token), topic);
    }

    @Override
    public void multipleUnsubscribeToTopic(List<String> tokens, String topic) throws FirebaseMessagingException {
        firebaseMessaging.unsubscribeFromTopic(tokens, topic);
    }

    @Override
    public void sendNotificationToToken(String token, NotificationDto notificationDto) throws FirebaseMessagingException {
        Notification notification = Notification.builder()
                .setBody(notificationDto.getBodyMessage())
                .setTitle(notificationDto.getTitle())
                .build();

        Message notificationMessage = Message.builder()
                .setToken(token)
                .setNotification(notification)
                .putAllData(notificationDto.getData())
                .build();

        firebaseMessaging.send(notificationMessage);
    }

    @Override
    public void sendNotificationToTopic(String topic, NotificationDto notificationDto) throws FirebaseMessagingException {
        Notification notification = Notification.builder()
                .setBody(notificationDto.getBodyMessage())
                .setTitle(notificationDto.getTitle())
                .build();

        Message notificationMessage = Message.builder()
                .setTopic(topic)
                .setNotification(notification)
                .putAllData(notificationDto.getData())
                .build();

        firebaseMessaging.send(notificationMessage);
    }
}



