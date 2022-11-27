package com.example.workers;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages={"com.example.workers.controller","com.example.workers.*"})
@MapperScan(basePackages = {"com/example/workers/dao"})
public class WorkersApplication {

    public static void main(String[] args) {
        SpringApplication.run(WorkersApplication.class, args);
    }

}
