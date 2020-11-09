package com.xrluo;

import com.xrluo.javaConfig.JavaBean3;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = JavaBean3.class)
// No qualifying bean of type 'com.xrluo.classes.ProfileDemo' available: expected at least 1 bean which qualifies as autowire candidate. Dependency annotations: {@org.springframework.beans.factory.annotation.Autowired(required=true)}
@ActiveProfiles("dev")
public class JavaBean4Test {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void demo1() {
        System.out.println(applicationContext.containsBean("test1"));
    }
}