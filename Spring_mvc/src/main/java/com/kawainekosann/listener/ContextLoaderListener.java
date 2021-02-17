package com.kawainekosann.listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextLoaderListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent sce) {
        //ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        //将Spring应用的上下文对象存储到servletContext域中
        ServletContext servletContext = sce.getServletContext();
        //读取web.xml中的全局参数
        String contextConfigLocation =servletContext.getInitParameter("contextConfigLocation");
        ApplicationContext app = new ClassPathXmlApplicationContext(contextConfigLocation);
        servletContext.setAttribute("app",app);
        System.out.println("spring容器创建完毕");
    }

    public void contextDestroyed(ServletContextEvent sce) {

    }
}
