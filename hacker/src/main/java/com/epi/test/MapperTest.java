package com.epi.test;

import com.epi.bean.Image1;
import com.epi.bean.User;
import com.epi.dao.UserMapper;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MapperTest {

    @Autowired
    UserMapper userMapper;
    @Autowired
    SqlSession sqlSession;
    @Test
    public void TestCRUD() throws Exception{

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 规定时间格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 获得现在的时间（字符串)
        String time = df.format(new Date());
        System.out.println(time);
        // 获得现在时间的格式(date）
        Date date = df.parse(time);
        //图片的路径
        String imagePath = "C:\\images\\XML.png";
        // 获得文件输入流
        FileInputStream fileInputStream = new FileInputStream(new File(imagePath));
        // 图片二进制流
        byte[] image = new byte[fileInputStream.available()];
        // 将文件内容写入image数组中
        fileInputStream.read(image);
        // 关闭输入流
        fileInputStream.close();
        String imageName = time.replaceAll(" ","").replaceAll(":","");
        String inPath = "C:\\inimages\\"+imageName+".png";
        FileOutputStream fileOutputStream = new FileOutputStream(new File(inPath));
        fileOutputStream.write(image);
        fileOutputStream.close();
        Image1 image1 = new Image1(date,inPath);
        userMapper.insertImageInfo(image1);

        /*
        // 用户注册

        */
        // 数据的更新

//        int j=10;
//        while(j--!=0){
//            String uid = UUID.randomUUID().toString().substring(0,5);
//            mapper.insertSelective(new User(null, uid, "34"+uid+"45",uid+"@qq.com","1"));
//        }
    }

}
