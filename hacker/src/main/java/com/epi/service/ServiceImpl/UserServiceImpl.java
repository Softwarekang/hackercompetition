package com.epi.service.ServiceImpl;

import com.epi.bean.User;
import com.epi.dao.ArticleMapper;
import com.epi.dao.UserMapper;
import com.epi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public void insertUser(User user) {
        userMapper.insertSelective(user);
    }

    @Override
    public User selectByUserName(String userName) {
        return userMapper.selectByUserName(userName);
    }
}
