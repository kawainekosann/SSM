package com.kawainekosann.factory;

import com.kawainekosann.dao.UserDao;
import com.kawainekosann.dao.impl.UserDaoImpl;

public class StaticFactory {
    public static UserDao getUserDao(){
    return new UserDaoImpl();
    };
}
