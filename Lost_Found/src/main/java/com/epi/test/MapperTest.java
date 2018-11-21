package com.epi.test;

import com.epi.bean.User;
import com.epi.dao.UserMapper;
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
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = df.format(new Date());
        Date date = df.parse(time);
        System.out.println(time);
        mapper.insert(new User(null,"安康","123","1214@",date));
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
