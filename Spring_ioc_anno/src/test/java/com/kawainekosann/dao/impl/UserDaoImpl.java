package com.kawainekosann.dao.impl;

import com.kawainekosann.dao.UserDao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/*<bean id="userDao" class="com.kawainekosann.dao.impl.UserDaoImpl" ></bean>*/
@Repository("userDao")
public class UserDaoImpl implements UserDao {
    public void save() {
        System.out.println("save running...");
    }
}
