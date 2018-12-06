**失物招领**

**关于项目：**

######项目起因:
*我们小组发现随着大家生活每天的速度越来越快,随之带来的也是干事情的大意.
也在校园中发现,大家丢东西的次数也增加了.因此我们针对这种事件,想要尽一己之力.
所以我们小组做了关于帮大家找东西和联系失主的网站.参加本次公益活动的主题.

######项目的预计效果:
>1.	此网页具有登录与注册功能
>2.	主页面搜索丢失物品
>3.	主页面上显示最新物品图片和主要信息,按时间展示
>4.	主页面有分类查找,如:一卡通,书本,等
>5.	点击物品图片可进入新页面查看详细信息
>6.	详细信息底下具有留言功能
>7.	在留言区可以进行多次评论联系失主

```
环境：jdk1.8 + mysql5.7 + maven + tomcat8 + IDEA
后端：spring + springmvc + mybatis
前端：html + css + js + jquery + editor(Markdown富文本编辑器)
数据库名称：epi_demo
```
本项目GitHub地址：[GitHub]

---
**注：**
本项目基于SSM框架，
[SSM框架整合]
>此项目全部代码纯手工编写

**项目目录结构**

### 1. 创建表结构(4张表)
```
create database epi_demo character set utf8;
```

1. user表
```
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) NOT NULL,
  `user_password` varchar(20) NOT NULL,
  `user_email` varchar(25) NOT NULL,
  `user_time` date DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8;
```

2. article表
```
CREATE TABLE `article` (
  `r_id` int(11) NOT NULL AUTO_INCREMENT,
  `r_author` varchar(100) DEFAULT NULL,
  `r_sort` varchar(100) DEFAULT NULL,
  `r_image` varchar(100) DEFAULT NULL,
  `r_content` text,
  `r_date` varchar(100) DEFAULT NULL,
  `r_status` int(11) DEFAULT NULL,
  PRIMARY KEY (`r_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
```

3. 留言表
```
CREATE TABLE `words` (
  #留言id编号
  `lw_id` int(11) NOT NULL AUTO_INCREMENT,
  #留言人名字
  `lw_name` varchar(100) DEFAULT NULL,
  #留言时间
  `lw_date` varchar(100) DEFAULT NULL,
  #留言内容
  `lw_content` varchar(300) DEFAULT NULL,
  #给谁留言
  `lw_for_name` varchar(100) DEFAULT NULL,
  #在哪篇文章下留言
  `lw_for_article_id` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`lw_id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;
```

4. 回复表
```
CREATE TABLE `reply` (
  #回复信息id编号
  `lr_id` int(11) NOT NULL AUTO_INCREMENT,
  #回复人名字
  `lr_name` varchar(100) DEFAULT NULL,
  #回复时间
  `lr_date` varchar(100) DEFAULT NULL,
  #回复内容
  `lr_content` varchar(300) DEFAULT NULL,
  #给谁回复
  `lr_for_name` varchar(100) DEFAULT NULL,
  #在哪个留言下的回复
  `lr_for_words` varchar(100) DEFAULT NULL,
  #在哪篇文章下的回复
  `lr_for_article_id` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`lr_id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;
```

### 留言回复功能

![](img/7.png)

### 基本功能
>用户登录，注册
>发布信息，图片
>搜索，查询

**详情请看GitHub上的源码**




