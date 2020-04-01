package com.example.design.demo.config;

import com.example.design.demo.interceptor.TokenInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;



//
@Configuration
public class WebConfig extends WebMvcConfigurationSupport{

    @Bean
    public TokenInterceptor getTokenInterceptor(){
        return new TokenInterceptor();
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //SpringMVC下，拦截器的注册需要排除对静态资源的拦截(*.css,*.js)
        //SpringBoot已经做好了静态资源的映射，因此我们无需任何操作
        registry.addInterceptor(getTokenInterceptor()).addPathPatterns("/**").excludePathPatterns("/api/login");
        super.addInterceptors(registry);
    }
}
