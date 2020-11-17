package com.xrluo;

import com.xrluo.classes.DemoBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
// 使用xml配置
@ContextConfiguration("classpath:/WEB-INF/applicationContext.xml")
public class DemoTest2 {

    @Autowired
    // 增加限定符,可以使用demo2,不然使用的是demo1
    @Qualifier("demo2")
    private DemoBase demo2;

    @Test
    public void speak() {
        demo2.speak();
    }


    @Test
    public void speak2() {
        demo2.speak2(5);
    }
}