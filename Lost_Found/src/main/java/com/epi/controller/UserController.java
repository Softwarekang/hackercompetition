package com.epi.controller;

import com.epi.bean.User;
import com.epi.dao.UserMapper;
import com.epi.service.UserService;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class UserController {
    @Autowired
    SqlSession sqlSession  ;
    @Autowired
    UserService userService;

    // 用户首次登录
    @RequestMapping("/hello")
    public String hello(ModelMap mv){
        return "login";
    }

    // 用户登录
    @RequestMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response, ModelMap mv){
        String userName = request.getParameter("username");
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.selectByUserName(userName);
        System.out.println(userName);
        if(user != null){
           // mv.addAttribute("loginIfo",userName);
            return "success";
        }
        return "login";
    }

    @RequestMapping("/regis")
    public String regist(){
        return "register";
    }

    @RequestMapping("/register")
    public String register(HttpServletRequest request, HttpServletResponse response, ModelMap mv) throws Exception{
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        String userName = request.getParameter("username");
        String passWord = request.getParameter("password");
        String email = request.getParameter("email");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = df.format(new Date());
        Date date = df.parse(time);
        userMapper.insert(new User(null,userName,passWord,email,date));
        return "login";
    }



}
