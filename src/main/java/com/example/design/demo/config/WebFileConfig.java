package com.example.design.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebFileConfig implements WebMvcConfigurer {
    @Bean(name = "multipartResolver")
    public MultipartResolver multipartResolver() {
        System.out.println("okkkkkkkkk");
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        //resolver.setMaxUploadSize(200*1024*1024);//上传文件大小 200M 50*1024*1024
        return resolver;
    }
}
