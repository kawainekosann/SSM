package com.kawainekosann.dao.impl;

import com.kawainekosann.dao.UserDao;
import com.kawainekosann.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

public class UserDaoImpl implements UserDao {
    public List<User> findAll() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<User> userList= Collections.singletonList((User) sqlSession.selectList("userMapper.findAll"));
        return userList;

    }
}
