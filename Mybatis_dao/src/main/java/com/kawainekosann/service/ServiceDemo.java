package com.kawainekosann.service;

import com.kawainekosann.dao.UserDao;
import com.kawainekosann.dao.impl.UserDaoImpl;
import com.kawainekosann.domain.User;

import java.io.IOException;
import java.util.List;

public class ServiceDemo {
    public static void main(String[] args) throws IOException {
        //创建dao层对象
        UserDao userDao = new UserDaoImpl();
        List<User> userList = userDao.findAll();
        System.out.println(userList);
    }
}
