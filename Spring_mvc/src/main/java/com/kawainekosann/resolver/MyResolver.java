package com.kawainekosann.resolver;

import com.kawainekosann.exception.MyException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyResolver implements HandlerExceptionResolver {
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ModelAndView modelAndView = new ModelAndView();
        //返回值是ModelAndView，对应跳转错误视图的信息
        if(ex instanceof MyException){
            modelAndView.addObject("info","自定义的异常");
            modelAndView.setViewName("error3");
        }else if(ex instanceof ArithmeticException){
            modelAndView.addObject("info","除数为0的异常");
            modelAndView.setViewName("error2");
        }
        return modelAndView;
    }
}
