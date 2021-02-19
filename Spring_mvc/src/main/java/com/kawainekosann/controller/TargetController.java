package com.kawainekosann.controller;

import com.kawainekosann.exception.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TargetController {
    @RequestMapping("/target")
    public ModelAndView save2() throws MyException {
        //Model模型：作用封装数据
        //view视图：作用展示数据
        System.out.println("目标资源执行");
        //int i = 1/0;
        MyException myException = new MyException("自定义异常");
        if("asd".equals("asd")){
            throw myException;
        }
        ModelAndView modelAndView = new ModelAndView();
        //设置模型数据
        modelAndView.addObject("userName","kawainekosann");
        //设置视图
        modelAndView.setViewName("success");
        return modelAndView;
    }
}
