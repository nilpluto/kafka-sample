package com.example.kafkasample.jar_consumer;

import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

// Annotations
@Configuration
@Component
@ConfigurationPropertiesScan
public class KafkaConfig {

    private String bootstrapServers;
    private String securityProtocol;
    private String saslMechanism;
    private String saslJaasConfig;
    private String consumerGroupId;
    private String consumerAutoOffsetReset;
    private String consumerValueDeserializer;

    public String getBootstrapServers() {
        return bootstrapServers;
    }

    public void setBootstrapServers(String bootstrapServers) {
        this.bootstrapServers = bootstrapServers;
    }

    public String getSecurityProtocol() {
        return securityProtocol;
    }

    public void setSecurityProtocol(String securityProtocol) {
        this.securityProtocol = securityProtocol;
    }

    public String getSaslMechanism() {
        return saslMechanism;
    }

    public void setSaslMechanism(String saslMechanism) {
        this.saslMechanism = saslMechanism;
    }

    public String getSaslJaasConfig() {
        return saslJaasConfig;
    }

    public void setSaslJaasConfig(String saslJaasConfig) {
        this.saslJaasConfig = saslJaasConfig;
    }

    public String getConsumerGroupId() {
        return consumerGroupId;
    }

    public void setConsumerGroupId(String consumerGroupId) {
        this.consumerGroupId = consumerGroupId;
    }

    public String getConsumerAutoOffsetReset() {
        return consumerAutoOffsetReset;
    }

    public void setConsumerAutoOffsetReset(String consumerAutoOffsetReset) {
        this.consumerAutoOffsetReset = consumerAutoOffsetReset;
    }

    public String getConsumerValueDeserializer() {
        return consumerValueDeserializer;
    }

    public void setConsumerValueDeserializer(String consumerValueDeserializer) {
        this.consumerValueDeserializer = consumerValueDeserializer;
    }

    @Bean
    public ConsumerFactory<String, String> consumerFactory() {
        // Creating a Map of string-object pairs
        Map<String, Object> config = new HashMap<>();
        applyKafkaConfig(config);
        return new DefaultKafkaConsumerFactory<>(config);
    }

    // Creating a Listener
    @Bean
    public ConcurrentKafkaListenerContainerFactory concurrentKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<
                String, String> factory
                = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }

    private void applyKafkaConfig(Map<String, Object> config) {
        // Adding the Configuration
        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        config.put(ConsumerConfig.GROUP_ID_CONFIG, consumerGroupId);
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        config.put(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, securityProtocol);
        config.put("sasl.mechanism", saslMechanism);
        config.put("auto-offset-reset", consumerAutoOffsetReset);
        config.put("sasl.jaas.config", saslJaasConfig);
    }
}

