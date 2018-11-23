package com.epi.controller;

import com.epi.bean.Image1;
import com.epi.bean.User;
import com.epi.dao.UserMapper;
import com.epi.service.UserService;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLDecoder;
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
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsFileUploadSupport;

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
        String password = request.getParameter("password");
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.selectByUserName(userName);
        System.out.println(userName);
        if(user != null && (user.getUserPassword().equals(password))){
           // mv.addAttribute("loginIfo",userName);
            return "success";
        }
        return "login";
    }

    // 用户注册
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

    // 异步判断用户是否已经注册
    @RequestMapping("/ajax")
    public void findByName(HttpServletRequest request,HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String userName = request.getParameter("username");
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.selectByUserName(userName);
        System.out.println(userName);
        if(user == null){
            response.getWriter().write("false");
        }else {
            response.getWriter().write("yes");
        }

    }


    // 上传图片
    @RequestMapping("/upFile")
    public String upFile(){
        return "upFile";
    }
    @RequestMapping("/upImages")
    public String upImage(MultipartFile  image) throws Exception{
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        String fileName = image.getOriginalFilename();
        System.out.println(fileName);
        // 获得上传文件的io流
        InputStream inputStream = image.getInputStream();
        // 规定时间格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 获得现在的时间（字符串)
        String time = df.format(new Date());
        // 获得现在时间的格式(date）
        Date date = df.parse(time);
        System.out.println(time);
        byte[] image1 = new byte[inputStream.available()];
        // 将文件内容写入image数组中
        inputStream.read(image1);
        // 关闭输入流
        inputStream.close();
        String imageName = time.replaceAll(" ","").replaceAll(":","");
        String inPath = "C:\\inimages\\"+imageName+".png";
        OutputStream fileOutputStream = new FileOutputStream(new File(inPath));
        fileOutputStream.write(image1);
        fileOutputStream.close();
        Image1 image2 = new Image1(date,inPath);
        userMapper.insertImageInfo(image2);
        return null;
    }

    // 照片回显
    @RequestMapping("/getImages")
    public String toDownImage(){
        return "getImages";
    }
    @RequestMapping("/getInformation")
    public String downImage(HttpServletRequest request) throws Exception{
        String inPath ="C:\\inimages\\2018-11-23151154.png";
        System.out.println(inPath);
        request.setAttribute("imageUrl",inPath);
        return "getImages";
    }



}
