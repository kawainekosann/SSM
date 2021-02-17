package com.kawainekosann.test;

import com.kawainekosann.domain.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class JdbcTemplateCRUDTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Test
    public void testUpdate() {
        jdbcTemplate.update("update account set money = ? where id =?", new Object[]{10000, 4});
    }
    @Test
    public void delete() {
        jdbcTemplate.update("delete from account where id = ?", "5");
    }
    @Test
    public void testQueryAll() {
        List<Account> accountList = jdbcTemplate.query("select * from account", new BeanPropertyRowMapper<Account>(Account.class));
        System.out.println(accountList);
    }
    @Test
    public void testQueryOne() {
        Account account = jdbcTemplate.queryForObject("select * from account where id = ?", new BeanPropertyRowMapper<Account>(Account.class), "3");
        System.out.println(account);
    }
    @Test
    public void testQueryCount() {
        Long account = jdbcTemplate.queryForObject("select count(*) from account",Long.class);
        System.out.println(account);
    }
}
