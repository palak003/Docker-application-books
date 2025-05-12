package com.example.docker.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class KafkaConsumer {
    private final List<String> msgs = new CopyOnWriteArrayList<>();

    @KafkaListener(topics = "${app.kafka.topic}", groupId = "${spring.kafka.consumer.group-id}")
    public void listen(String message) {
        msgs.add(message);
    }

    public List<String> getAll() {
        return msgs;
    }
}