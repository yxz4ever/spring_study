package com.xrluo.javaConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaBean2 {

    @Bean
    public String test1() {
        return "测试...............";
    }

}
