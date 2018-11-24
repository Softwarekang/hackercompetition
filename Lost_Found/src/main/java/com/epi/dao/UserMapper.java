package com.epi.dao;

import com.epi.bean.Goods;
import com.epi.bean.Image1;
import com.epi.bean.User;
import com.epi.bean.UserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    long countByExample(UserExample example);

    int deleteByExample(UserExample example);
    // 按照ID删除用户信息
    int deleteByPrimaryKey(Integer userId);


    // 获得所有User信息
   // List<User> getUserList();
    List<User> selectByExample(UserExample example);
    // 必须实现User的默认构造函数，才可以生成User类
    // 按照ID查询user
    User selectByPrimaryKey(Integer userId);
    // 按照ID查询user
    User selectByKey(Integer id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);
    // @更新user数据
    int updateByPrimaryKeySelective(User record);
    // @更新user数据
    int updateByPrimaryKey(User record);

    // 照片的下载
    void insertImageInfo(Image1 image1);
    // 按照username查找验证(登录和注册)
    User selectByUserName(String username);
    // @插入user信息（注册)
    int insertSelective(User record);
    int insert(User record);

    // 实现上传发布
    void insertProject(Goods good);
    // 照片的回显 先按照name查询
    Goods getImageInfo(String username);
}