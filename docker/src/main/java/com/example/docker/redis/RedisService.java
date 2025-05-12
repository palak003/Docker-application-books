package com.example.docker.redis;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisService {
    private final StringRedisTemplate redis;

    public RedisService(StringRedisTemplate redis) {
        this.redis = redis;
    }

    /** Set a value for the given key (no TTL). */
    public void set(String key, String value) {
        redis.opsForValue().set(key, value);
    }

    /** Get the value for the given key (returns null if missing). */
    public String get(String key) {
        return redis.opsForValue().get(key);
    }
}
