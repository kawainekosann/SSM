package com.kawainekosann.factory;

import com.kawainekosann.dao.UserDao;
import com.kawainekosann.dao.impl.UserDaoImpl;

public class DynamicFactory {
    public UserDao getUserDao(){
        return new UserDaoImpl();
    };
}
