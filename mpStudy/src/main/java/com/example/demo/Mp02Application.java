package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * MP启动注入了SQL原理分析
 *
 */
@MapperScan("com.example.demo.mapper")
@SpringBootApplication
public class Mp02Application {

    public static void main(String[] args) {
        SpringApplication.run(Mp02Application.class, args);
    }

}
