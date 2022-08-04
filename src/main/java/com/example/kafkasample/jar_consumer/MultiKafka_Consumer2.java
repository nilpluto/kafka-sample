package com.example.kafkasample.jar_consumer;

// Importing required classes
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MultiKafka_Consumer2 {

    @KafkaListener(topics = "${kafka.user2.topic}",
            containerFactory = "concurrentKafkaListenerContainerFactory")
    public void processMessage(String message) {
        System.out.println("Message received from Topic 2: "+message);
    }
}

