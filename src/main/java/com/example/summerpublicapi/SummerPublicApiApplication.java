package com.example.summerpublicapi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableScheduling
@EnableAsync
@SpringBootApplication
@ComponentScan(basePackages = {"com.example"})
@MapperScan(value = "com.example.summerpublicapi.**.mapper")
public class SummerPublicApiApplication  {

    public static void main(String[] args) {
        SpringApplication.run(SummerPublicApiApplication.class, args);
    }



}
