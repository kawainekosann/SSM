package com.kawainekosann.test;

import com.kawainekosann.domain.User;
import com.kawainekosann.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
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
}
