package vn.spring.nam.notification.service;

import com.google.firebase.messaging.FirebaseMessagingException;

import java.util.List;

public interface FcmService<T> {
    void subscribeToTopic(String token, String topic) throws FirebaseMessagingException;

    void multipleSubscribeToTopic(List<String> tokens, String topic) throws FirebaseMessagingException;

    void unsubscribeFromTopic(String token, String topic) throws FirebaseMessagingException;

    void multipleUnsubscribeToTopic(List<String> tokens, String topic) throws FirebaseMessagingException;

    void sendNotificationToToken(String token, T message) throws FirebaseMessagingException;

    void sendNotificationToTopic(String topic, T message) throws FirebaseMessagingException;
}
