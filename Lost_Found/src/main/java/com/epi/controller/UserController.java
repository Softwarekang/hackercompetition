package com.epi.controller;

import com.epi.bean.Goods;
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
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.FilenameUtils;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsFileUploadSupport;

@Controller
public class UserController {
    @Resource(name="sqlSession")
    SqlSession sqlSession  ;
    @Autowired
    UserService userService;

    // 用户首次登录
    @RequestMapping("/hacker")
    public String hello(ModelMap mv){
        return "login";
    }

    // 用户登录
    @RequestMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response, ModelMap mv){
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        if(userName.equals("")){
            mv.addAttribute("loginInfo","用户名不能为空");
            return "login";
        }else if(password.equals("")){
            mv.addAttribute("loginInfo","密码不能为空");
            return "login";
        }else{
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = userMapper.selectByUserName(userName);
            System.out.println(userName);
            if(user != null && (user.getUserPassword().equals(password))){
                mv.addAttribute("loginIfo",userName);
                return "success";
            }else {
                mv.addAttribute("loginInfo","用户名或密码错误");
                return "login";
            }
        }


    }

    // 用户注册
    @RequestMapping("/regis")
    public String regist(){
        return "register";
    }

    @RequestMapping("/register")
    public String register(HttpServletRequest request, HttpServletResponse response, ModelMap mv) throws Exception{
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
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
            userMapper.insert(new User(null,userName,passWord,email,date));
            return "login";
        }else{
            return "register";
        }

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


    // 长传信息
    @RequestMapping("/upFile")
    public String upFile(){
        return "upFile";
    }

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public String upImage(HttpServletRequest request,@RequestParam("description") String description,
        @RequestParam("goods") String goods,@RequestParam("file") MultipartFile file) throws Exception{
        System.out.println(description+goods);
        // 获得上传文件名
        String fileName = file.getOriginalFilename();
        System.out.println(fileName);
        // 动态代理接口
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 规定时间格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 获得现在的时间（字符串)
        String time = df.format(new Date());
        // 获得现在时间的格式(date）
        Date date = df.parse(time);
        System.out.println(time);
        // 文件的后缀名
        String ext = FilenameUtils.getExtension(fileName);
        // 获得上传文件的输入流
        InputStream inputStream = file.getInputStream();
        // 信息中介数组
        byte[] image1 = new byte[inputStream.available()];
        // 将文件内容写入image数组中
        inputStream.read(image1);
        // 关闭输入流
        inputStream.close();
        // 将时间设置为图片名称(秒)
        String imageName = time.replaceAll(" ","").replaceAll(":","");
        // 图片存入磁盘的路径
        String realUploadPath=request.getServletContext().getRealPath("/");
        System.out.println(realUploadPath);
        String inPath = "/images/"+imageName+"."+ext;
        String inPath1 = "C:\\Users\\安康\\IdeaProjects\\Lost_Found\\src\\main\\webapp"+"\\images\\"+imageName+"."+ext;
        // 文件路径的输出流
        OutputStream fileOutputStream = new FileOutputStream(new File(inPath1));
        // 写入信息
        fileOutputStream.write(image1);
        // 刷新和关闭
        fileOutputStream.flush();
        fileOutputStream.close();
        // 存入数据库
        // 主键没有设置因此就先自己每次设置一下 不能重复
        Goods good = new Goods(1,goods,description,inPath);
        userMapper.insertProject(good);
        return "upFileSuccess";
    }

    // 长传成功进行跳转 回到主页面
    @RequestMapping("/toSuccess")
    public String toSuccess(){
        return "success";
    }
    // 照片回显
    @RequestMapping("/getImages")
    public String toDownImage(){
        return "getImages";
    }
    @RequestMapping("/getInformation")
    public String downImage(HttpServletRequest request) throws Exception{
        String inPath ="http://localhost:9995/images/2018-11-27153553.png";
        System.out.println(inPath);
        request.setAttribute("imageUrl",inPath);
        return "getImages";
    }



}
