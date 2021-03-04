package com.kawainekosann;

import com.kawainekosann.domain.Orders;
import com.kawainekosann.domain.User;
import com.kawainekosann.mapper.OrderMapper;
import com.kawainekosann.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;


public class MybatisTest {
    Logger logger = Logger.getLogger(MybatisTest.class);
    private UserMapper mapper;
    private SqlSession sqlSession;

    @Test
    public void test1() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSession sqlSession = new SqlSessionFactoryBuilder().build(resourceAsStream).openSession();
        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
        List<Orders> ordersList = mapper.findAll();
        System.out.println(ordersList);
    }

    @Test
    public void test2() throws IOException {
        //List<User> userList = mapper.findAllMsg();
        List<User> userList = mapper.findAll();
        System.out.println(userList);
    }

    @Test
    public void test3() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSession sqlSession = new SqlSessionFactoryBuilder().build(resourceAsStream).openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.findUserAndRole();
        System.out.println(userList);
    }


    @Before
    public void init() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        sqlSession = new SqlSessionFactoryBuilder().build(resourceAsStream).openSession();
        mapper = sqlSession.getMapper(UserMapper.class);
    }

    @Test
    public void test4() {
        User select = mapper.select(1);
        System.out.println(select);
    }

    @Test
    public void test5() throws IOException {
        User user = new User();
        user.setId(4);
        user.setUserName("liuqi4");
        user.setPassWord("4liuqi");
        user.setBirthday(new Date());
        mapper.update(user);
        sqlSession.commit();
    }

    @Test
    public void test6() throws IOException {
        User user = new User();
        user.setId(5);
        user.setUserName("liuqi5");
        user.setPassWord("5liuqi");
        user.setBirthday(new Date());
        mapper.save(user);
        sqlSession.commit();
    }

    @Test
    public void test7() {
        List<User> userList = mapper.findAll();
        System.out.println(userList);
    }

    @Test
    public void test8() {
        mapper.delete(5);
        sqlSession.commit();
    }

    @Test
    public void test9() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSession sqlSession = new SqlSessionFactoryBuilder().build(resourceAsStream).openSession();
        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
        List<Orders> ordersList = mapper.findAll();
        System.out.println(ordersList);
    }

    @Test
    public void test10() throws IOException {
        List<User> userList = mapper.findUserAndOrders();
        System.out.println(userList);
        sqlSession.close();
    }

    @Test
    public void test11() throws IOException {
        List<User> userList = mapper.findUserAndRole();
        System.out.println(userList);
        sqlSession.close();
    }
}
