package com.xrluo;

import com.xrluo.classes.ProfileDemo;
import com.xrluo.javaConfig.JavaBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = JavaBean.class)
@ActiveProfiles("prod")
public class JavaBeanTest {

    @Autowired
    private ProfileDemo demo;

    @Test
    public void demo() {
        System.out.println(demo.getSt());
    }

}