package com.kawainekosann.test;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcTemplateTest {
    @Test
    //测试JdbcTemplate开发步骤
    public void test1(){
        DruidDataSource  dataSource  = new DruidDataSource();
        dataSource.setUsername("root");
        dataSource.setPassword("67iwxh1314");
        dataSource.setUrl("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8");
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        //设置数据源对象，知道数据库在哪儿
        jdbcTemplate.setDataSource(dataSource);
        int row = jdbcTemplate.update("insert into account (name,money) values (?,?)", new Object[]{"liu", 500});
        System.out.println(row);
    }

    @Test
    public void Test2(){
        ApplicationContext app= new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate) app.getBean("jdbcTemplate");
        int row = jdbcTemplate.update("insert into account (name,money) values (?,?)", new Object[]{"liu", 500});
        System.out.println(row);
    }
}
