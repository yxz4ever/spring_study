package com.xrluo;

import com.xrluo.javaConfig.JavaBean2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = JavaBean2.class)
public class JavaBean2Test {

    @Autowired
    private String test1;

    @Test
    public void demo1() {
        System.out.println(test1);
    }

}