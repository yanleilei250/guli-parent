package com.yll.eduservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author 颜起名
 * @create date 2020-07-24-23:16
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.yll")
public class EduApplication {
    public static void main(String[] args) {
        SpringApplication.run(EduApplication.class, args);
    }
}
