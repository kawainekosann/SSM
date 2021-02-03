package com.kawainekosann.web;

import com.kawainekosann.config.ApplicationConfig;
import com.kawainekosann.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserController {
    public static void main(String[] args) {
        //ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        ApplicationContext app = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        UserService userService = app.getBean(UserService.class);
        userService.save();
        System.out.println(app.getBean("dataSource").toString());
        ((AnnotationConfigApplicationContext)app).close();
    }
}
