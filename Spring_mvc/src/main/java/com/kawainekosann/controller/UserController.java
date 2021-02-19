package com.kawainekosann.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kawainekosann.domain.User;
import com.kawainekosann.domain.VO;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping(value = "/quick",method = RequestMethod.GET,params = {"userName"})
    public String save() {
        System.out.println("controller save running...");
        //转发地址不变 http://localhost:8080/user/quick?userName
        //return "forward:/jsp/success.jsp";
        //转发地址变化 变为http://localhost:8080/success.jsp
        //return "redirect:/jsp/success.jsp";
        //配置前缀后缀后 http://localhost:8080/user/quick?userName
        return "success";
    }

    @RequestMapping("/quick2")
    public ModelAndView save2(){
        //Model模型：作用封装数据
        //view视图：作用展示数据
        ModelAndView modelAndView = new ModelAndView();
        //设置模型数据
        modelAndView.addObject("userName","kawainekosann");
        //设置视图
        modelAndView.setViewName("success");
        return modelAndView;
    }

    @RequestMapping("/quick3")
    //此处需要一个ModelAndView对象，这里Spring会帮你注入一个该对象
    public ModelAndView save3(ModelAndView modelAndView){
        //设置模型数据
        modelAndView.addObject("userName","kawainekosann");
        //设置视图
        modelAndView.setViewName("success");
        return modelAndView;
    }

    @RequestMapping("/quick4")
    public String save4(Model model){
        model.addAttribute("userName","kawainekosann");
        return "success";
    }

    @RequestMapping("/quick5")
    public String save5(HttpServletRequest request){
        request.setAttribute("userName","kawainekosann");
        return "success";
    }

    @RequestMapping("/quick6")
    public void save6(HttpServletResponse response) throws IOException {
        response.getWriter().print("hellow feimao!");
    }

    @RequestMapping("/quick7")
    @ResponseBody  //告知SpringMVC框架 不进行视图跳转 直接进行数据响应
    public String save7(){
     return "hellow feimao!";
    }

    @RequestMapping("/quick8")
    @ResponseBody
    public String save8(){
        return "{\"userName\":\"feimao\",\"age\":\"27\"}";
    }

    @RequestMapping("/quick9")
    @ResponseBody
    public String save9() throws JsonProcessingException {
        User user = new User();
        user.setUserName("feimao");
        user.setAge(27);
        //使用Json转换工具，将对象转换成json字符串在返回
        ObjectMapper objectMapper = new ObjectMapper();
        String json=objectMapper.writeValueAsString(user);
        return json;
    }

    @RequestMapping("/quick10")
    @ResponseBody
    //期望SpringMVC自动将User转换成json字符串
    public User save10() throws JsonProcessingException {
        User user = new User();
        user.setUserName("feimao!");
        user.setAge(27);
        return user;
    }

    @RequestMapping("/quick11")
    @ResponseBody //代表不进行页面跳转
    public void save11(String userName,int age){
        System.out.println(userName);
        System.out.println(age);
    }

    @RequestMapping("/quick12")
    @ResponseBody //代表不进行页面跳转
    //SpringMVC自动将注入User对应的属性
    public void save12(User user){
        System.out.println(user);
    }

    @RequestMapping("/quick13")
    @ResponseBody //代表不进行页面跳转
    public void save13(String[] strs){
        System.out.println(Arrays.asList(strs));
    }

    @RequestMapping("/quick14")
    @ResponseBody //代表不进行页面跳转
    public void save14(VO vo){
        System.out.println(vo);
    }

    @RequestMapping("/quick15")
    @ResponseBody //代表不进行页面跳转
    public void save15(@RequestBody List<User> users){
        System.out.println(users);
    }

    @RequestMapping("/quick16")
    @ResponseBody //代表不进行页面跳转
    //http://localhost:8080/user/quick16?name=liu @RequestParam的value写页面链接的属性名
    public void save16(@RequestParam(value = "name",required = false,defaultValue = "feimao") String userName){
        System.out.println(userName);
    }

    /*
     * GET：用于获取资源    /user/1 GET：得到id=1的user
     * POST：用于新建资源    /user/1 POST：新增user
     * PUT：用于更新资源     /user/1 PUT：更新id=1的user
     * DELETE：用于删除资源     /user/1 DELETE：删除id=1的user
     */
    @RequestMapping(value = "/quick17/{name}",method = RequestMethod.GET)
    @ResponseBody //代表不进行页面跳转
    //http://localhost:8080/user/quick17/liu
    public void save17(@PathVariable(value = "name",required = true) String userName){
        System.out.println(userName);
    }

    @RequestMapping("/quick18")
    @ResponseBody //代表不进行页面跳转
    //SpringMVC自动将注入User对应的属性
    public void save18(Date date){
        System.out.println(date);
    }

    @RequestMapping("/quick19")
    @ResponseBody //代表不进行页面跳转
    //SpringMVC自动将注入User对应的属性
    public void save19(HttpServletRequest request, HttpServletResponse response, HttpSession session){
        System.out.println(request);
        System.out.println(response);
        System.out.println(session);
    }

    @RequestMapping("/quick20")
    @ResponseBody //代表不进行页面跳转
    //SpringMVC自动将注入User对应的属性
    public void save20(@RequestHeader(value = "User-agent",required = false)  String user_agent){
        System.out.println(user_agent);
    }

    @RequestMapping("/quick21")
    @ResponseBody //代表不进行页面跳转
    //SpringMVC自动将注入User对应的属性
    public void save21(@CookieValue(value = "JSESSIONID",required = false)  String jsessionId){
        System.out.println(jsessionId);
    }

    @RequestMapping("/quick22")
    @ResponseBody
    public void save22(String userName, MultipartFile uploadFile,MultipartFile uploadFile2) throws IOException {
        System.out.println(userName);
        //获得上传文件的名称
        String originalFilename = uploadFile.getOriginalFilename();
        uploadFile.transferTo(new File("C:\\Users\\LIUQI\\Desktop\\test\\upload\\"+originalFilename));

        String originalFilename2 = uploadFile2.getOriginalFilename();
        uploadFile2.transferTo(new File("C:\\Users\\LIUQI\\Desktop\\test\\upload\\"+originalFilename2));
    }
}
