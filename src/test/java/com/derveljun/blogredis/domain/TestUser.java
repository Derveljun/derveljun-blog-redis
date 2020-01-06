package com.derveljun.blogredis.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestUser {

    @Autowired
    UserRepository userRepository;

    @Test
    public void test () {
        User user = User.builder().id(UUID.randomUUID()).name("Test").build();

        User saved = userRepository.save(user);

        assertNotNull(saved);

    }

}
