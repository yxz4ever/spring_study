package com.xrluo.classes.impl;

import com.xrluo.classes.DemoBase;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("demo2")
public class Demo2 implements DemoBase {
    @Override
    public String speak() {
        System.out.println("demo2 测试...................");
        return "demo2 测试...................";
    }

    @Override
    public String speak2(Integer integer) {
        System.out.println(integer);
        return "................";
    }
}
