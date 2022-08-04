package com.example.kafkasample;

import com.example.kafkasample.jar_consumer.MultiKafkaConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
@EnableConfigurationProperties(MultiKafkaConfig.class)
public class KafkaSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaSampleApplication.class, args);
	}

}
