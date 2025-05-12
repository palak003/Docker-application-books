package com.example.docker.kafka;

import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@Configuration
public class KafkaConfig {
    // Spring Boot auto-configures the necessary beans from application.properties
}
