package com.kawainekosann.controller;

import com.kawainekosann.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AccountController {
    public static void main(String[] args) {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountService accountService = (AccountService) app.getBean("accountServiceImpl");
        accountService.transfer("liu2","liu",5000);
    }
}
