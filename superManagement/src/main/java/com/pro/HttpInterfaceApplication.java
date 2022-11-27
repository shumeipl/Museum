package com.pro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import sun.applet.Main;

import javax.xml.ws.WebServiceClient;
@SpringBootApplication
@MapperScan("com.pro.mapper")
//@ServletComponentScan("com.pro.filter")
public class HttpInterfaceApplication {

    public static void main(String[] args) {
        SpringApplication.run(HttpInterfaceApplication.class, args);
    }



}
