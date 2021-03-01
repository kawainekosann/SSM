package com.kawainekosann;

import com.kawainekosann.domain.Orders;
import com.kawainekosann.domain.User;
import com.kawainekosann.mapper.OrderMapper;
import com.kawainekosann.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class MybatisTest {
    Logger logger = Logger.getLogger(MybatisTest.class);

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
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSession sqlSession = new SqlSessionFactoryBuilder().build(resourceAsStream).openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.findAll();
        System.out.println(userList);
    }
}
