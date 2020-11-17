package com.xrluo;

import com.xrluo.classes.DemoBase;
import com.xrluo.config.AspectConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AspectConfig.class)
public class DemoTest1 {

    @Autowired
    // 增加限定符,可以使用demo2,不然使用的是demo1
    @Qualifier("demo2")
    private DemoBase demo2;

    @Test
    public void speak() {
        demo2.speak();
    }
}