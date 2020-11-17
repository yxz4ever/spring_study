package com.xrluo.classes.impl;

import com.xrluo.classes.DemoBase;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Demo1 implements DemoBase {
    @Override
    public String speak() {
        System.out.println("demo1 测试...................");
        return "demo1 测试...................";
    }

    @Override
    public String speak2(Integer integer) {
        return null;
    }
}
