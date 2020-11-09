package com.xrluo.javaConfig;

import com.xrluo.classes.ProfileDemo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ComponentScan(basePackageClasses = ProfileDemo.class)
public class JavaBean {


    @Profile("dev")
    @Bean
    public ProfileDemo test1() {
        ProfileDemo demo = new ProfileDemo();

        demo.setSt("当前profile是dev");

        return demo;
    }


    @Profile("prod")
    @Bean
    public ProfileDemo test2() {

        ProfileDemo demo = new ProfileDemo();

        demo.setSt("当前profile是prod");

        return demo;
    }

}
