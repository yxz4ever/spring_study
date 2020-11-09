package com.xrluo.javaConfig;

import com.xrluo.condition.EnvExistsCondition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaBean3 {

    @Bean
    @Conditional(EnvExistsCondition.class)
    public String test1() {
        return "测试...............";
    }
}
