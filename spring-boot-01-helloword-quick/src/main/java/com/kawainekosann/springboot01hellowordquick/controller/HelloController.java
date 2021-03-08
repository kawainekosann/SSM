package com.kawainekosann.springboot01hellowordquick.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//直接回写数据给浏览器，如果是对象则转换成Json数据
/*@Controller
@ResponseBody*/
@RestController
public class HelloController {
    @Value("${person.last-name}")
    private String name;

    @RequestMapping("/hello")
    public String hello(){
        return "hello word quick" + name;
    }
}
