package com.kawainekosann.service;

import com.kawainekosann.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
//写在开头表示这是该类全局配置，如果类和方法上都配置了，以方法为主
//@Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED)
public class AccountServiceImpl implements AccountService{
    @Autowired
    private AccountDao accountDao;

    /*public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }*/

    @Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED)
    public void transfer(String outMan, String inMan, double money) {
        //开启事务
        accountDao.out(outMan,money);
        int i = 1/0;
        accountDao.in(inMan,money);
        //提交事务
    }
    //每个方法可以配自己的
    @Transactional(propagation = Propagation.REQUIRED)
    public void xxx(){};
}
