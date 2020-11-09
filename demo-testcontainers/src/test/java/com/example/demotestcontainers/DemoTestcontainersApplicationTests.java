package com.example.demotestcontainers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootTest
class DemoTestcontainersApplicationTests {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    void contextLoads() {
        String version = jdbcTemplate.queryForObject("select version()", String.class);
        System.out.println("*************************");
        System.out.println(version);
        System.out.println("*************************");
    }

}
