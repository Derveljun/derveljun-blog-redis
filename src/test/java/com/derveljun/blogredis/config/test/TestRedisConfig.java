package com.derveljun.blogredis.config.test;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import redis.embedded.RedisServer;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.stream.Collectors;

@Slf4j
//@Profile({"local", "dev", "test"}) Runtime 실행 시 프로파일을 꼭 추가해야한다.
@Configuration
public class TestRedisConfig {

    private RedisServer redisServer;

    public TestRedisConfig(@Value("${spring.redis.port}") int redisPort) {
        redisServer = new RedisServer(redisPort);
        log.info("Embedded Redis Object Created");
    }

    @PostConstruct
    public void startRedis() {
        redisServer.start();
        log.info("Embedded Redis Started");
        log.info(" >> Port: " + redisServer.ports().stream().map(n -> String.valueOf(n)).collect(Collectors.joining()));
    }

    @PreDestroy
    public void stopRedis() {
        redisServer.stop();
        log.info("Embedded Redis Stopped");
    }

}
