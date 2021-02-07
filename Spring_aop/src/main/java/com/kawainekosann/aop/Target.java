package com.kawainekosann.aop;

import org.springframework.stereotype.Component;

public class Target implements TargetInterface {
    public void save() {
        int i = 1/0;
        System.out.println("save runing...");
    }
}
