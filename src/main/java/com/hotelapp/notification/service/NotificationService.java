package com.hotelapp.notification.service;

import com.hotelapp.notification.event.ReservationCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class NotificationService {
    @KafkaListener(topics = "reservation-created-topic", groupId = "notification-group")
    public void handleReservationCreated(String event) {
        System.out.println("Kafka'dan gelen JSON string: " + event);
        log.info("📩 Notification Service: E-posta gönderildi! -> {}", event);
    }
}
