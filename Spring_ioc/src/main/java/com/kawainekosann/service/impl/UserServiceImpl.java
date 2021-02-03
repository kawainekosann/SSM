package com.kawainekosann.service.impl;

import com.kawainekosann.dao.UserDao;
import com.kawainekosann.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    /*public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }*/

    public UserServiceImpl() {
    }

    public void save() {
        userDao.save();
    }
}
