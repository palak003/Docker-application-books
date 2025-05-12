package com.example.docker.kafka;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {
    private final KafkaTemplate<String, String> template;
    @Value("${app.kafka.topic}") private String topic;

    public KafkaProducer(KafkaTemplate<String, String> template) {
        this.template = template;
    }

    public void send(String msg) {
        template.send(topic, msg);
    }
}