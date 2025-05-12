// src/main/java/com/example/demo/controller/KafkaController.java
package com.example.docker.kafka;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/kafka")
public class KafkaController {

  private final KafkaProducer producer;
  private final KafkaConsumer consumer;

  public KafkaController(KafkaProducer producer, KafkaConsumer consumer) {
    this.producer = producer;
    this.consumer = consumer;
  }

  /** 
   * Publish a message to Kafka: 
   * curl -X POST "http://localhost:8080/api/kafka/publish" -d "message=Hello" 
   */
  @PostMapping("/publish")
  public ResponseEntity<Void> publish(@RequestParam String message) {
    producer.send(message);
    return ResponseEntity.accepted().build();
  }

  /**
   * Retrieve all consumed messages:
   * curl http://localhost:8080/api/kafka/messages
   */
  @GetMapping("/messages")
  public List<String> messages() {
    return consumer.getAll();
  }
}
