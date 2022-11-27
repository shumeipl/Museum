package com.pro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

@SpringBootApplication
@MapperScan("com.pro.mapper")
@ComponentScan(basePackages = {"com.pro.*"})
public class MuApplication {
    public static void main(String[] args) {
        SpringApplication.run(MuApplication.class,args);
    }
}
