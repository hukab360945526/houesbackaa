package com.team.houes.houesbacka;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.team.houes.houesbacka.mapper")
public class HouesbackaApplication {

    public static void main(String[] args) {
        SpringApplication.run(HouesbackaApplication.class, args);
    }

}
