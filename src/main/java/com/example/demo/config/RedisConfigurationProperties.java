package com.example.demo.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.HashMap;
import java.util.Map;


@ConfigurationProperties(prefix = "cache")
public class RedisConfigurationProperties {
    @Value("${spring.redis.timeout}")
    private long timeoutOfSeconds;
    @Value("${spring.redis.port}")
    private int port;
    @Value("${spring.redis.host}")
    private String host;
    @Value("${spring.redis.topic}")
    private String topic;
    // Mapping of cacheNames to expire-after-write timeout in seconds
    private Map<String, Long> cacheExpiration = new HashMap<>();

    public long getTimeoutOfSeconds() {
        return timeoutOfSeconds;
    }

    public void setTimeoutOfSeconds(long timeoutOfSeconds) {
        this.timeoutOfSeconds = timeoutOfSeconds;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Map<String, Long> getCacheExpiration() {
        return cacheExpiration;
    }

    public void setCacheExpiration(Map<String, Long> cacheExpiration) {
        this.cacheExpiration = cacheExpiration;
    }
}
