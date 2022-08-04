package com.example.kafkasample.jar_consumer;

// Importing required classes
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MultiKafka_Consumer1 {

    @KafkaListener(topics = "${kafka.user1.topic}",
            containerFactory = "concurrentKafkaListenerContainerFactory")
    public void processMessage(String message) {
        System.out.println("Message received from Topic 1: "+message);
    }
}

