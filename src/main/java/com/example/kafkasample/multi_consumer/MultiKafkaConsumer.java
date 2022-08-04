/*
package com.example.kafkasample.multi_consumer;

// Importing required classes
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MultiKafkaConsumer {

    @KafkaListener(topics = "${cloudkarafka.topic}",
            containerFactory = "concurrentKafkaListenerContainerFactory")
    public void processMessage(String message) {
        System.out.printf("message received");
    }
}

*/
