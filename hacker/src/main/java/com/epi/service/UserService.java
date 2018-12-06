package com.epi.service;

import com.epi.bean.User;

public interface UserService {
    void insertUser(User user);

    User selectByUserName(String userName);

    User selectByUserId(Integer id);
}
