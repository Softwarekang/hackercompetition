package com.epi.dao;

import com.epi.bean.User;
import com.epi.bean.UserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    long countByExample(UserExample example);

    int deleteByExample(UserExample example);
    // 按照ID删除用户信息
    int deleteByPrimaryKey(Integer userId);
    // @插入user信息
    int insert(User record);
    // @插入user信息
    int insertSelective(User record);
    // 获得所有User信息
   // List<User> getUserList();

    List<User> selectByExample(UserExample example);
    // 必须实现User的默认构造函数，才可以生成User类
    // 按照ID查询user
    User selectByPrimaryKey(Integer userId);
    // 按照ID查询user
    User selectByKey(Integer id);
    // 按照username查找验证
    User selectByUserName(String username);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);
    // @更新user数据
    int updateByPrimaryKeySelective(User record);
    // @更新user数据
    int updateByPrimaryKey(User record);
}