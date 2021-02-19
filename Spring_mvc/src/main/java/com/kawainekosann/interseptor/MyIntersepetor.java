package com.kawainekosann.interseptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyIntersepetor implements HandlerInterceptor {
    //在目标方法执行之前执行
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle");
        if(request.getParameter("param").equals("yes")){
            return true;
        }else{
            request.getRequestDispatcher("/jsp/error.jsp").forward(request,response);
         return false;
        }

    }

    //在目标方法执行之后，视图返回之前执行
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        modelAndView.addObject("userName","dafeiao");
        System.out.println("postHandle");//可以修改视图
    }

    //在整个流程都执行完毕后执行
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion");
    }
}
