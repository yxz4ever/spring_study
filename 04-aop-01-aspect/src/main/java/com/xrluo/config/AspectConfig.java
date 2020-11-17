package com.xrluo.config;

import com.xrluo.aspect.DemoAspect;
import com.xrluo.classes.DemoBase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackageClasses = DemoBase.class)
public class AspectConfig {

    @Bean
    public DemoAspect demoAspect() {
        return new DemoAspect();
    }
}
