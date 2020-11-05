package com.xrluo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ScanConfig.class)
public class UserTest {

    @Autowired
    private User user;

    @Test
    public void getName() {
        user.setName("氷落");
        user.setAge(32);

        System.out.println(user);
    }
}