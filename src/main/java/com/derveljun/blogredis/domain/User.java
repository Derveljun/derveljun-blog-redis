package com.derveljun.blogredis.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.util.UUID;

@RedisHash("user")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {

    @Id
    private UUID id;

    private String name;

}
