package com.example.kafkasample.jar_consumer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@ConfigurationProperties(prefix = "kafka")
@Component
@ConfigurationPropertiesScan
public class MultiKafkaConfig {

    @Autowired
    KafkaConfig user1;

    @Autowired
    KafkaConfig user2;

    public KafkaConfig getUser1() {
        return user1;
    }

    public void setUser1(KafkaConfig user1) {
        this.user1 = user1;
    }

    public KafkaConfig getUser2() {
        return user2;
    }

    public void setUser2(KafkaConfig user2) {
        this.user2 = user2;
    }
}
