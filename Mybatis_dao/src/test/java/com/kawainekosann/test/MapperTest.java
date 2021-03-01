package com.kawainekosann.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kawainekosann.domain.User;
import com.kawainekosann.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MapperTest {
   private Logger logger =  Logger.getLogger(this.getClass());
    @Test
    public void test1() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSession sqlSession = new SqlSessionFactoryBuilder().build(resourceAsStream).openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User userCondition = new User();
        userCondition.setId(3);
        //userCondition.setUserName("liuqi1");
        List<User> userList = mapper.findByCondition(userCondition);
        System.out.println(userList);

        /*List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        List<User> userList2 = mapper.findByIds(list);
        System.out.println(userList2);

        User user = new User();
        user.setId(3);
        user.setUserName("liuqi3");
        user.setPassWord("3liuqi");
        user.setBirthday(new Date());
        mapper.save(user);
        sqlSession.commit();*/
    }


    @Test
    public void test2() throws IOException {
        InputStream sqlMapConfig = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSession = new SqlSessionFactoryBuilder().build(sqlMapConfig);
        SqlSession sqlSession1 = sqlSession.openSession();
        UserMapper mapper = sqlSession1.getMapper(UserMapper.class);

        //设置分页的相关参数 当前页+每页显示的条书
        PageHelper.startPage(1,2);
        List<User> userList = mapper.findAll();
        //获得与分页相关参数
        PageInfo<User> pageInfo = new PageInfo<User>(userList);
        logger.info("当前页数"+pageInfo.getPageNum());
        logger.info("页面条数"+pageInfo.getPageSize());
        logger.info("总条数"+pageInfo.getTotal());
        logger.info("总页数"+pageInfo.getPages());
        logger.info("上一数"+pageInfo.getPrePage());
        logger.info("下一数"+pageInfo.getNextPage());
        logger.info("是否第一页"+pageInfo.isIsFirstPage());
        logger.info("是否最后一页"+pageInfo.isIsLastPage());

        System.out.println(userList);
    }
}
