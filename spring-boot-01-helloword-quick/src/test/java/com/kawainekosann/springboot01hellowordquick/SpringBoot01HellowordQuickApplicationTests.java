package com.kawainekosann.springboot01hellowordquick;

import com.kawainekosann.springboot01hellowordquick.bean.Person;
import com.kawainekosann.springboot01hellowordquick.service.HelloService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

/*
 * springboot单元测试
 * 可以在测试期间很方便的用类似编码一样进行自动注入等容器等功能
 * */
@SpringBootTest
class SpringBoot01HellowordQuickApplicationTests {
    @Autowired
    Person person;

    @Autowired
    ApplicationContext ioc;

    @Test
    void contextLoads() {
        System.out.println(person);
    }

    @Test
    void contextLoads2() {
        System.out.println(ioc.containsBean("helloService02"));
    }

}
