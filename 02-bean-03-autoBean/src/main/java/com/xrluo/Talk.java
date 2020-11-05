package com.xrluo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Talk {

    private User user;

    @Autowired
    public Talk(User user) {
        this.user = user;
    }

    public void speak() {
        System.out.println(user);
    }

}
