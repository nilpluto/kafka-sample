package com.example.kafkasample.multi_kafka_consumer;


import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "kafka")
public class MultiKafkaConfig {

    @Autowired
    KafkaConfig user1;

    @Autowired
    KafkaConfig user2;
}
