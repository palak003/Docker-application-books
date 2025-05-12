// src/main/java/com/example/demo/controller/RedisController.java
package com.example.docker.redis;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/redis")
public class RedisController {

    private final RedisService redisService;

    public RedisController(RedisService redisService) {
        this.redisService = redisService;
    }

    /**
     * Set a key in Redis:
     *   POST http://localhost:8080/api/redis/{key}?value=yourValue
     */
    @PostMapping("/{key}")
    public ResponseEntity<Void> setKey(
            @PathVariable String key,
            @RequestParam String value
    ) {
        redisService.set(key, value);
        return ResponseEntity.accepted().build();
    }

    /**
     * Get a key from Redis:
     *   GET http://localhost:8080/api/redis/{key}
     */
    @GetMapping("/{key}")
    public ResponseEntity<String> getKey(@PathVariable String key) {
        String val = redisService.get(key);
        if (val == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(val);
    }
}
