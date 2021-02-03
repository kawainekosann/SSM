package com.kawainekosann.service.impl;

import com.kawainekosann.dao.UserDao;
import com.kawainekosann.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/*<bean id="userService" class="com.kawainekosann.service.impl.UserServiceImpl" >*/
@Service("userService")
@Scope("singleton") //单例的
//@Scope("prototype") //多例的
public class UserServiceImpl implements UserService {
    /*<property name="userDao" ref="userDao"></property>*/
    //如果只写@Autowired就会按照数据类型从Spring容器中进行匹配这里匹配UserDAO所以可以不写@Qualifier
    //@Autowired
    //@Qualifier("userDao") //这里写要注入的bean的id
    @Resource(name = "userDao")//这里写要注入的bean的id,相当于@Autowired+@Qualifier("userDao")
    private UserDao userDao;
    //使用注解方式时，不需要写set方法
    /*public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }*/

    //注入普通属性，相当于applicationContext里的value，
    //因为applicationContext已经引入了jdbc.properties所以这边可以用EL表达式赋值
    @Value("${jdbc.driver}")
    private String driver;


    public void save() {
        System.out.println(driver);
        userDao.save();
    }

    @PostConstruct//初始化方法
    public void init(){
        System.out.println("对象初始化方法");
    }

    @PreDestroy//销毁方法
    public void Destory(){
        System.out.println("对象销毁方法");
    }
}
