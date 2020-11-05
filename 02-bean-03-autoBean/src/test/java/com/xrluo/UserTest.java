package com.xrluo;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ScanConfig.class)
public class UserTest {

    @Rule
    public final StandardOutputStreamLog log = new StandardOutputStreamLog();
    @Autowired
    private User user;
    @Autowired
    private Talk talk;

    @Test
    public void userShouldNotBeNull() {
        assertNotNull(user);
    }

    @Test
    public void demo1() {
        user.setName("氷落");
        user.setAge(23);

        talk.speak();
        // 此处断言,要与控制台输出的一致,要不然会报错
        assertEquals("User{name='氷落', age=23}\n", log.getLog());
    }
}