package com.kawainekosann.service;

import com.kawainekosann.dao.UserDao;
import com.kawainekosann.dao.impl.UserDaoImpl;
import com.kawainekosann.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ServiceDemo {
    /*public static void main(String[] args) throws IOException {
        //创建dao层对象
        UserDao userDao = new UserDaoImpl();
        List<User> userList = userDao.findAll();
        System.out.println(userList);
    }*/
    public static void main(String[] args) throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSession sqlSession = new SqlSessionFactoryBuilder().build(resourceAsStream).openSession();
        //通过getMapper获得一个接口的动态代理类实现，调用代理类的方法去实现增删改查
        UserDao mapper = sqlSession.getMapper(UserDao.class);

        List<User> users = mapper.findAll();
        System.out.println(users);

        User user = mapper.findById(2);
        System.out.println(user);
    }
}
