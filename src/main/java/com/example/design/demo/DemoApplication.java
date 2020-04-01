package com.example.design.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        // 拦截器中动态获取bean时，可以直接获取到ConfigurableApplicationContext
        SpringApplication.run(DemoApplication.class, args);
    }

}
