package com.example.websample.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

@Configuration
public class WebConfig {

    @Bean
    public FilterRegistrationBean loggingFilter(){
        FilterRegistrationBean<Filter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
        filterFilterRegistrationBean.setFilter(new LogFilter());
        filterFilterRegistrationBean.setOrder(1); // 필터를 걸 순서 설정
        filterFilterRegistrationBean.addUrlPatterns("/payment"); // 필터를 걸 url 주소 설정
        return filterFilterRegistrationBean;

    }
}
