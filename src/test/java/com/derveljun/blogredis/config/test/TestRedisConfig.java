package com.derveljun.blogredis.config.test;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import redis.embedded.RedisServer;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.IOException;

//import redis.embedded.RedisServer;

@Slf4j
@Profile({"local", "dev", "test"})
@Configuration
public class TestRedisConfig {

    private RedisServer redisServer;

    public TestRedisConfig(@Value("${spring.redis.port}") int redisPort) {
        redisServer = new RedisServer(redisPort);
    }

    @PostConstruct
    public void startRedisServer() throws IOException {
        redisServer.start();
    }

    @PreDestroy
    public void preDestroy() {
        redisServer.stop();
    }

}
