package com.kawainekosann.demo;

import com.kawainekosann.dao.UserDao;
import com.kawainekosann.service.UserService;
import com.kawainekosann.service.impl.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class UserController {
    public static void main(String[] args) {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        //ApplicationContext app = new FileSystemXmlApplicationContext("src/main/resources/applicationContext.xml");
        //UserService userService = (UserService) app.getBean("UserService");
        UserService userService = (UserService) app.getBean(UserService.class);
        userService.save();


        //空指针错误，因为并非从Spring容器中获取，所以Dao对象没有注入，调用save方法会空指针
        //UserService userService1 = new UserServiceImpl();
        //userService1.save();
    }
}
