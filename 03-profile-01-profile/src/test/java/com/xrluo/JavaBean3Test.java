package com.xrluo;

import com.xrluo.classes.ProfileDemo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:WEB-INF/applicationContent.xml")
// No qualifying bean of type 'com.xrluo.classes.ProfileDemo' available: expected at least 1 bean which qualifies as autowire candidate. Dependency annotations: {@org.springframework.beans.factory.annotation.Autowired(required=true)}
@ActiveProfiles("prod")
public class JavaBean3Test {

    @Autowired
    private ProfileDemo test1;

    @Test
    public void demo1() {
        System.out.println(test1.getSt());
    }


}