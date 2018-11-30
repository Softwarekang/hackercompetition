package com.epi.controller;

import com.epi.bean.User;
import com.epi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;

@RequestMapping("/user")
@Controller
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value="/login",method= RequestMethod.GET)
    public String login(){
        return "user/login";
    }
    @RequestMapping(value="/login",method= RequestMethod.POST)
    public String login(HttpServletRequest request, HttpServletResponse response, ModelMap mv){
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        if(userName.equals("")){
            mv.addAttribute("loginInfo","用户名不能为空");
            return "user/login";
        }else if(password.equals("")){
            mv.addAttribute("loginInfo","密码不能为空");
            return "user/login";
        }else{
            User user = userService.selectByUserName(userName);
            System.out.println(userName);
            if(user != null && (user.getUserPassword().equals(password))){
                mv.addAttribute("loginIfo",userName);
                return "user/success";
            }else {
                mv.addAttribute("loginInfo","用户名或密码错误");
                return "user/login";
            }
        }


    }

    @RequestMapping(value="/regis",method= RequestMethod.GET)
    public String regist(){
        return "user/regist";
    }
    @RequestMapping(value="/register",method= RequestMethod.POST)
    public String register(HttpServletRequest request, HttpServletResponse response, ModelMap mv) throws Exception{
        String userName = request.getParameter("userName");
        String passWord = request.getParameter("userPassword");
        String confirmPassword = request.getParameter("user_confirm_password");
        String email = request.getParameter("email");
        Boolean register = true;
        if(userName.equals("")){
            mv.addAttribute("registerInfo","用户名不能为空");
            register = false;
        } else if(passWord.equals("")){
            mv.addAttribute("registerInfo","密码不能为空");
            register = false;
        } else if(confirmPassword.equals("")){
            mv.addAttribute("registerInfo","请输入确定密码");
            register = false;
        } else if(!passWord.equals(confirmPassword)){
            mv.addAttribute("registerInfo","两次密码输入不同");
            register = false;
        }else if (email.equals("")) {
            mv.addAttribute("registerInfo","邮箱不能为空");
            register = false;
        } else{

        }
        if(register){
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String time = df.format(new Date());
            Date date = df.parse(time);
            userService.insertUser(new User(null,userName,passWord,email,date));
            return "user/login";
        }else{
            return "user/regist";
        }

    }


    // 异步判断用户是否已经注册
    @RequestMapping("/ajax")
    public void findByName(HttpServletRequest request,HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String userName = request.getParameter("username");
        User user = userService.selectByUserName(userName);
        System.out.println(userName);
        if(user == null){
            response.getWriter().write("false");
        }else {
            response.getWriter().write("yes");
        }

    }





}
