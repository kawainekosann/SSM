package com.kawainekosann;

import com.kawainekosann.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    @Test
    public void test1() throws IOException {
        //获得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行操作 参数 namespace+id
        List<User> userList = sqlSession.selectList("userMapper.findAll");
        System.out.println(userList);
        //释放资源
        sqlSession.close();
    }

    @Test
    public void test2() throws IOException {
        //获得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //模拟User对象
        User user = new User();
        user.setUserName("liuqi4");
        user.setPassWord("44444444");
        //执行操作 参数 namespace+id
        sqlSession.insert("userMapper.save", user);
        //默认是事务 不提交，这里要提交才有效果
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }

    @Test
    public void test3() throws IOException {
        //获得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //模拟User对象
        User user = new User();
        user.setId(4);
        user.setUserName("liuqi4");
        user.setPassWord("44444444");
        //执行操作 参数 namespace+id
        sqlSession.update("userMapper.update", user);
        //默认是事务 不提交，这里要提交才有效果
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }

    @Test
    public void test4() throws IOException {
        //获得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行操作 参数 namespace+id
        sqlSession.delete("userMapper.delete", 5);
        //默认是事务 不提交，这里要提交才有效果
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }
}
