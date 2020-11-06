package com.xrluo;

import com.xrluo.classes.People;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "/WEB-INF/config2.xml")
public class Test3 {

    @Rule
    public final StandardOutputStreamLog log = new StandardOutputStreamLog();
    @Autowired
    private People user;

    @Test
    public void userShouldNotBeNull() {
    }

    @Test
    public void demo1() {
        System.out.println(user.song());
        // 此处断言,要与控制台输出的一致,要不然会报错
        // assertEquals("User{name='氷落', age=23}\n", log.getLog());
    }
}